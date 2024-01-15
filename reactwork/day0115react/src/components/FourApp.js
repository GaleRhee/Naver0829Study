import React from 'react';
import img1 from '../images/ninjasm.png';
import img2 from '../images/wonmin.png';
import img3 from '../images/SanSanMulMul.webp';
import img4 from '../images/byebyepap.jpeg';
import './MyStyle.css';


function FourApp(props) {
    //4개의 import 된 이미지들 배열에 저장
    const myImage = [img1, img2, img3, img4];

    //객체 형식의 데이터 배열을 반복문으로 출력하기
    const data = [
        { "name": "강호동", "addr": "Seoul", "hp": "010-222-3333", "photo": "C1" },
        { "name": "이효리", "addr": "Pusan", "hp": "010-233-3444", "photo": "C3" },
        { "name": "배수지", "addr": "Jeju", "hp": "010-111-5555", "photo": "C5" },
        { "name": "설석현", "addr": "Pohang", "hp": "010-234-5678", "photo": "C8" }
    ]

    return (
        <div>
            <h3 className='alert alert-success'>FourApp - map 으로 이미지 배열 출력</h3>
            {
                myImage.map((img, idx) => (<img alt='' src={img} width='200' />))
            }
            <hr />
            {
                data.map((ele, i) => (
                    <div className='box' key={i}>
                        <h5>이름 : {ele.name}</h5>
                        <h5>주소 : {ele.addr}</h5>
                        <h5>핸드폰 : {ele.hp}</h5>
                        <img alt="프로필 사진" src={require(`../images/${ele.photo}.png`)} width='120' />
                    </div>
                ))
            }
            <hr />
            <table className='table table-bordered' style={{ width: '500px' }}>
                <thead>
                    <tr>
                        <td width='50'>번호</td>
                        <td width='100'>사진</td>
                        <td width='100'>이름</td>
                        <td width='150'>핸드폰</td>
                        <td>주소</td>
                    </tr>
                </thead>
                {/* thead, tbody 꼭 써야 한다 */}
                <tbody>
                    {
                        data.map((ele, idx) => (
                            <tr key={idx}>
                                <td>{idx + 1}</td>
                                <td>
                                    <img alt="프로필 사진"
                                        src={require(`../images/${ele.photo}.png`)}
                                        width='80' />
                                </td>
                                <td>{ele.name}</td>
                                <td>{ele.hp}</td>
                                <td>{ele.addr}</td>
                            </tr>
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
}

export default FourApp;