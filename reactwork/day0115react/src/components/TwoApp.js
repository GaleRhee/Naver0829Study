import React, { useEffect, useState } from 'react';
import Tibet from '../images/Tibet Fox.webp';
import verylate from '../images/verylate.jpg';

function TwoApp(props) {
    const [show, setShow] = useState(true);
    const [count, setCount] = useState(1);

    const clickButtonEvent = () => {
        //순차 처리가 아닌 비동기 처리라 언제 실행될지 모른다
        //React에서 언제나 주의 해야 함
        //비동기 처리라 아래 코드가 먼저 호출 될 수도 있다
        //이럴 때 쓰는 것이 useEffect 이다
        setCount(count + 1);
        //setShow(count % 3 === 0 ? true : false);

        //원태가 알려준 방법
        // setCount((prev)=>{
        //     let nextCount=prev+1;
        //     setShow(nextCount%3===0);
        //     return nextCount;
        // })
    }

    useEffect(() => {
        setShow(count % 3 === 0 ? true : false);
    }, [count]); //count 변경 시 자동 호출

    return (
        <div>
            <h3 className='alert alert-danger'>TwoApp - 3의 배수만 이미지 보이기/안보이기</h3>
            <button type="button" className='btn btn-danger'
                onClick={clickButtonEvent}>숫자 증가</button>
            <b style={{ fontSize: '4em', color: 'red', marginLeft: '50px' }}>{count}</b>
            <br /><br />
            {
                // show가 true 일 때 보이는 이미지
                show &&
                <img alt="" src={Tibet} />
            }
            {
                //show 가 false 일 때 보이는 이미지
                !show &&
                <img alt="" src={verylate} />
            }

            {/* src 의 이미지를 import 없이 출력하는 방법 */}
            <img alt="" src={require('../images/blind.jpg')} />
        </div>
    );
}

export default TwoApp;