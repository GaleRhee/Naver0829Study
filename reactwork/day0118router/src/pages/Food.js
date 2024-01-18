import { Alert } from '@mui/material';
import React from 'react';
import { useParams } from 'react-router-dom';

const Food = () => {
    const { food1, food2 } = useParams();
    console.log({ food1 }, { food2 });

    return (
        <div>
            <Alert variant='filled' severity='info'>
                Food 컴포넌트입니다
            </Alert>
            {
                food1 == null && food2 == null ? <h3>저는 오늘 점심 식사를 하지 않겠습니다</h3> :
                    food1 != null && food2 == null ?
                        //emp 값 넘어오지 않은 경우 실행할 영역
                        <div>
                            <h4>오늘의 점심 메뉴</h4>
                            <img alt='' src={require(`../image/${food1}.jpg`)} width={300} />
                            <h1>오늘 후식은 없습니다</h1>
                        </div>
                        :
                        //emp 값이 있는 경우 실행할 영역
                        <div>
                            <h4>오늘의 점심 메뉴</h4>
                            <img alt='' src={require(`../image/${food1}.jpg`)} width={300} />
                            <h4>오늘의 후식</h4>
                            <img alt='' src={require(`../image/${food2}.jpg`)} width={300} />
                        </div>
            }
        </div>
    );
};

export default Food;