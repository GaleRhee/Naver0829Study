import React, { useState } from 'react';
import './MyStyle.css';
import injung from '../images/injung.jpg';

function TwoApp(props) {
    //함수형에서 state 변수 선언하는 방법, state 변수가 아니면 변경이 안되고 출력만 됨 
    const [number,setNumber]=useState(0);

    return (
        <div className="box">
                <h3 className="alert alert-success">TwoApp
                    <img alt="" src={injung}
                    style={{width: '60px', float: 'right'}}/>
                </h3>
                <div style={{fontSize: '40px',color: 'red', marginLeft: '200px'}}>
                    {number}
                </div>
                <div style={{marginLeft: '122px'}}>
                    <button type='button' className='btn btn-outline-success'
                    onClick={()=>{
                        if(number===0){ //== 는 값만 비교, ===는 타입까지 비교
                            alert("0 이하 감소할 수 없습니다");
                            return; //함수 종료
                        }
                        setNumber(number-1);
                    }}>숫자 감소</button>

                    <button type='button' className='btn btn-outline-success'
                    style={{marginLeft: '10px'}}
                    onClick={()=>{
                        if(number===10){ //== 는 값만 비교, ===는 타입까지 비교
                            alert("10 이상 증가할 수 없습니다");
                            return; //함수 종료
                        }
                        setNumber(number+1);
                    }}>숫자 증가</button>
                </div>
            </div>
    );
}

export default TwoApp;