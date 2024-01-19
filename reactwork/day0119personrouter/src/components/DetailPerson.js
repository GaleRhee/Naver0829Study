import { ArrowBack, ArrowBackIosNew, ArrowBackIosNewOutlined, ArrowBackIosNewRounded, EditNote, RefreshRounded } from '@mui/icons-material';
import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

const DetailPerson = () => {
    const { pnum } = useParams();
    const [selectData, setSelectData] = useState('');
    const navi = useNavigate();

    //pnum에 대한 dto 를 얻어서 selectData 에 넣는다
    const getSelectData = () => {
        const url = "/person/select?pnum=" + pnum;
        axios.get(url)
            .then(res => {
                setSelectData(res.data);
            })
    }

    //처음 로딩 시 딱 한 번 호출
    useEffect(() => {
        getSelectData();
    }, []);

    return (
        <div className='mainbox'>
            <h2>
                <ArrowBackIosNewRounded
                    style={{ fontSize: '0.8em', cursor: 'pointer' }}
                    //-1 : 이전 페이지로 이동
                    onClick={() => navi("/")} />
                &nbsp;
                <b>{selectData.name}</b> 님의 개인 정보
            </h2>
            {
                //데이터를 불러오기도 전에 useEffect 가 처리 되어서 문제가 될 수 있기에 이렇게 비동기 처리 해줘야 한다
                selectData.photo &&
                <img alt='' src={require(`../images/${selectData.photo}`)}
                    style={{ maxWidth: '350px' }} />
            }
            <hr />
            <h6>
                혈액형 : {selectData.blood} 형

                <EditNote
                    style={{ fontSize: '2em', float: 'right', cursor: 'pointer' }}
                    onClick={() => navi(`/updateform/${selectData.pnum}`)} />
            </h6>
            <h6>나  이 : {selectData.age} 세</h6>
            <h6>
                가입일 : {selectData.writeday}
                <ArrowBack
                    style={{ fontSize: '2em', float: 'right', cursor: 'pointer' }}
                    //-1 : 이전 페이지로 이동
                    onClick={() => navi(-1)} />
            </h6>
        </div>
    );
};

export default DetailPerson;