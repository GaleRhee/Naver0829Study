import React from 'react';
import { useLocation, useSearchParams } from 'react-router-dom';

function useQuery() {
    return new URLSearchParams(useLocation().search);
}

const QueryString = () => {
    //url 의 쿼리 스트링 값을 얻는 두 가지 방법
    //useParams 처럼 라우트에 등록 안 해도 된다
    let query = useQuery();

    const color = query.get("color");
    const name = query.get("name");
    const addr = query.get("addr");

    //2 번째 방법
    let [query2, setQuery2] = useSearchParams();
    const color2 = query2.get("color");
    const name2 = query2.get("name");
    const addr2 = query2.get("addr");

    return (
        <div>
            <h3 className='alert alert-success'>Query String 읽는 방법</h3>
            <div style={{ backgroundColor: color }}>
                배경색 : {color} <br />
                이 름 : {name} <br />
                주 소 : {addr}
            </div>
            <br />
            <div style={{ backgroundColor: color2 }}>
                배경색 : {color2} <br />
                이 름 : {name2} <br />
                주 소 : {addr2}
            </div>
        </div>
    );
};

export default QueryString;