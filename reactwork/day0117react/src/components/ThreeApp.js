import { Alert } from '@mui/material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import ThreeCardApp from './ThreeCardApp';

function Three(props) {
    const [personList, setPersonList] = useState([]);

    const list = () => {
        //백엔드로부터 데이터를 가져와서 배열 변수에 넣기
        axios.get("/person/list")
            .then(res => {
                setPersonList(res.data);
            })
    }

    useEffect(() => {
        console.log("useEffect")
        list(); //처음 시작 시 무조건 호출
    }, []); //변수 안에 아무것도 없으면 처음 시작 시 한번만 호출

    return (
        <div>
            <div>
                <Alert severity='success' variant='filled'>
                    <h3>ThreeApp - MUI 의 Card 를 이용한 목록 출력하기</h3>
                    {
                        personList.map((item, idx) => (
                            <div>
                                <ThreeCardApp key={idx} item={item} />
                                <hr />
                            </div>
                        ))
                    }
                </Alert>
            </div>
        </div>
    );
}

export default Three;