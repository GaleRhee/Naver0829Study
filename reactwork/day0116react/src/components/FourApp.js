import { Alert } from '@mui/material';
import React, { useState } from 'react';
import FourChildApp from './FourChildApp';

//** 부모, 자식간의 통신 **
//** 1. 부모 컴포넌트에서 자식 컴포넌트로 props 를 통해서 값이나 이벤트 전달을 할 수 있다 **
//** 2. 자식 컴포넌트에서는  부모 컴포넌트의 값을 props 로 받아서 출력은 가능하지만 직접적으로 변경은 불가능하다 **
//** 3. 만약 변경하려면 부모의 이벤트를 props를 통해서 호출을 해서 그 이벤트 함수에서 변경을 하면 된다 **
//*** props 는 부모 컴포넌트가 설정하며, 컴포넌트 자신은 해당 props 를 읽기 전용으로만 사용할 수 있다 **
//** 컴포넌트 내부에서 읽고 또 업데이트 하려면 state 를 써야 한다 ** 

function FourApp(props) {
    const [count, setCount] = useState(0);

    //count 를 증가하는 함수
    const changeCount = () => {
        setCount(count + 1);
    }
    return (
        <div>
            {/* <Alert severity='success'>
                <h3>FourApp - 부모 자식 간 통신</h3>
            </Alert> */}
            <h3 className='alert alert-danger'>FourApp - 부모 자식 간 통신</h3>
            <h4><b>방문 횟수 : {count} 회</b></h4>
            <FourChildApp name={"캔디"} age={"23세"} addr={"제주도"} incre={changeCount} />
            <FourChildApp name={"안쏘니"} age={"27세"} addr={"LA"} incre={changeCount} />
            <FourChildApp name={"테리우스"} age={"31세"} addr={"하와이"} incre={changeCount} />
        </div>
    );
}

export default FourApp;