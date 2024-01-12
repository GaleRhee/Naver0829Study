import React, { useState } from 'react';
import jingjing from '../images/jingjing.jpg';
import goat from '../images/goat.jpg';
import injung from '../images/injung.jpg';
import jingjingjab from '../images/jingjingjab.jpg';
import lovestar from '../images/lovestar.jpg';
import mapsosa from '../images/mapsosa.jpg';

function FiveApp(props) {
    const [show, setShow]=useState(true);
    const [photo,setPhoto]=useState(injung);
    const [border,setBorder]=useState('inset');

    return (
        <div className='box'>
            <h3 className='alert alert-warning'>FiveApp
                <img alt="" src={jingjing}
                style={{width: '60px', float: 'right'}}/>
            </h3>
            <div>
                <label>
                    <input type='checkbox' defaultChecked
                    onClick={(e)=>{
                        setShow(e.target.checked);
                    }}/>
                    이미지 보이기/안보이기
                </label>
                <br/><br/>
                <select className='form-select' style={{width: '200px'}}
                onChange={(e)=>{
                    setPhoto(e.target.value);
                }}>
                    <option value={goat}>goat</option>
                    <option value={jingjingjab}>jingjingjab</option>
                    <option value={lovestar}>lovestar</option>
                    <option value={jingjing}>jingjing</option>
                    <option value={mapsosa}>mapsosa</option>
                </select>
                <br/>
                <select className='form-select' style={{width: '200px'}}
                onChange={(e)=>{
                    setBorder(e.target.value);
                }}>
                    <option>inset</option>
                    <option>dotted</option>
                    <option>solid</option>
                    <option>dashed</option>
                    <option>double</option>
                    <option>groove</option>
                </select>
                <br/>
                {
                    //!show && : hide, show 값이 true 면 이미지가 보이고, false 면 안보인다
                    show && 
                    <img alt="" src={photo} style={{width: '300px',border: `10px ${border} gray`}}/>
                }
            </div>
        </div>
    );
}

export default FiveApp;