//초기 리액트 컴포넌트가 클래스로 구현 되었다
import React,{Component} from "react";
import './MyStyle.css';
import bow from '../images/bowwow.jpg';
import byebyepap from '../images/byebyepap.jpeg';

//class OneApp extends React.Component
class OneApp extends Component
{
    //class 에서 변경 가능한 state 변수 선언하는 방법
    //ES6 에서 생성자 선언하는 방법
    constructor()
    {
        super(); //super 생략 시 오류 **
        //state 로 줘야지 안에 변수 변경이 가능하다
        this.state={
            number:0
        }
    }

    render(){
        //style 을 변수로 저장한 후 적용하는 방법
        const imgStyle={
            border: '2px solid green',
            width: '330px',
            boxShadow: '3px 3px 3px gray'
        }

        const fontStyle={
            color: 'gray',
            fontFamily: 'SingleDay',
            marginTop: '20px'
        }

        const message="Have a Good Day!!"; //변경이 필요 없는 메세지 변수 선언

        return(
            <div className="box" style={{backgroundColor: 'pink'}}>
                <h3 className="alert alert-danger">OneApp
                    <img alt="" src={bow}
                    style={{width: '60px', float: 'right'}}/>
                </h3>
                {/* 변수를 style 에 지정하는 방법 */}
                <img alt="" src={byebyepap} style={imgStyle}/>
                <h2 style={fontStyle}>{message}</h2>

                <div style={{fontSize: '40px', color: 'red', marginLeft: '30px'}}>
                    {/* class 일 경우 state 변수 출력하는 방법 */}
                    {this.state.number}
                </div>
                <button type="button" className="btn btn-outline-danger"
                onClick={()=>{
                    //number 값 1씩 증가
                    this.setState({
                        number:this.state.number+1
                    })
                }}>Number 증가</button>
            </div>
        )
    }
}

//export default OneApp; //default 는 단 한 번만 가능, import 시에 이름 변경 가능
export {OneApp} //여러번 export 가능, import 시에 {OneApp} 으로 import, 이름 변경 안됨
