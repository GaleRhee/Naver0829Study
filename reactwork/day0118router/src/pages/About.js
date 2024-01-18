import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';
import simg from '../image/C1.png';
import gimg from '../image/C4.png';

const About = () => {
    const { emp } = useParams();
    console.log({ emp }); //{"emp":"Samsung"}
    console.log({ emp }.emp); //Samsung

    return (
        <div>
            <Alert variant='filled' severity='warning'>
                About 컴포넌트입니다
            </Alert>
            {
                emp == null ?
                    //emp 값 넘어오지 않은 경우 실행할 영역
                    <div>
                        <h1>저는 취업 준비생입니다</h1>
                        <img alt='' src={require(`../image/C7.png`)} />
                    </div>
                    :
                    //emp 값이 있는 경우 실행할 영역
                    <div>
                        <h1>저는 {emp} 사에 다니고 있습니다</h1>
                        <img alt='' src={(emp === 'Samsung' ? simg : gimg)} />
                    </div>
            }
        </div>
    );
};

export default About;