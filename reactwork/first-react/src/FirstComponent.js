import React from "react";
import './MyStyle.css';
import jingjing from './jingjing.jpg';
import gom from './gomnichiwa.jpg';

let FirstComponent=()=>{

    return (
        <div className="box">
            <h3 className="alert alert-danger">FirstComponent 컴포넌트</h3>
            <h6>public 의 이미지 나타내기</h6>
            {/* public 이미지는 직접 경로로 지정해야 함 - 권장 안함 */}
            <img alt="" src="cat quiet.jpg" 
            style={{border:'3px solid pink' ,width: '400px'}}/>
            <h6>src 의 이미지 나타내기</h6>
            <img alt="" src={jingjing} 
            style={{border:'3px solid pink' ,width: '200px'}}/>
            <img alt="" src={gom} 
            style={{border:'3px solid pink' ,width: '200px' ,marginLeft: '10px'}}/>
        </div>
    )
}

export default FirstComponent;