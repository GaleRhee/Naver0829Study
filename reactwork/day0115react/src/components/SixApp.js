import React, { useState } from 'react';

function SixApp(props) {
    const [mycar, setMycar] = useState(["2", "7"]);
    const [carno, setCarno] = useState('');
    return (
        <div>
            <h3 className='alert alert-danger'>SixApp - 문제</h3>
            <input type='text' placeholder='자동차 번호 입력 후 엔터'
                className='form-control'
                style={{ width: '300px' }}
                value={carno}
                onChange={(e) => setCarno(e.target.value)}
                onKeyUp={(e) => {
                    if (e.key === 'Enter') {
                        //1~15 가 아니면 경고 후 종료
                        if (carno < 1 || carno > 15) {
                            alert("1~15 사이의 숫자로만 입력해주세요");
                            setCarno('');
                            return;
                        }

                        //배열 mycar 에 carno 값 추가
                        setMycar(mycar.concat(e.target.value));

                        //carno 값 초기화
                        setCarno('');
                    }
                }} />

            {/* 1~15 사이 번호 입력 후 엔터를 누르면 해당 자동차 이미지로 출력하고
            해당 자동차 이미지에서 더블 클릭하면 자동차 삭제하기 */}
            {
                //mycar 배열 이미지로 출력 (width='100')
                mycar.map((photo, i) =>
                    <img alt="" key={i}
                        src={require(`../images/mycar${photo}.png`)}
                        width='100' hspace='10' vspace='10'
                        onDoubleClick={(e) => {
                            alert(i + " 인덱스 이미지 삭제!!");
                            setMycar(mycar.filter((p, idx) => (i !== idx)));
                        }} />)
            }
        </div>
    );
}

export default SixApp;