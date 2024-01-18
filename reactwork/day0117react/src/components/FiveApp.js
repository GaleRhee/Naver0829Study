import { Alert } from '@mui/material';
import React, { useEffect, useState } from 'react';
import styled from "styled-components";
import Pagination from "./Pagination";
import axios from 'axios';
import FourGuestRowItem from './FourGuestRowItem';
import FourGuestForm from './FourGuestForm';

function FiveApp(props) {
    // const [posts, setPosts] = useState([]);
    const [guestList, setGuestList] = useState([]);
    const [limit, setLimit] = useState(5);
    const [page, setPage] = useState(1);
    const offset = (page - 1) * limit;

    //저장 함수
    const onGuestSave = (data) => {//data 에는 닉네임과 글이 들어 있다
        axios.post("/guest/insert", data)
            .then(res => {
                //추가 성공 후 목록 다시 출력
                list();
            })
    }

    //목록 출력하는 함수
    const list = () => {
        axios.get("/guest/list")
            .then(res => {
                setGuestList(res.data)
            })
    }

    //처음 시작 시 목록 출력
    useEffect(() => {
        list();
    }, []); //처음 한번만 호출

    // useEffect(() => {
    //     fetch("https://jsonplaceholder.typicode.com/posts")
    //         .then((res) => res.json())
    //         .then((data) => setPosts(data));
    // }, []);

    //삭제
    const onDelete = (gnum) => {
        axios.delete("/guest/delete?gnum=" + gnum)
            .then(res => {
                //삭제 성공 후 목록 다시 출력
                //alert("삭제 성공!!");
                list();
            })
    }

    return (
        <Layout>
            <Alert severity='success' variant='filled'>
                <h3>FiveApp - Pagination</h3>
            </Alert>
            <br />
            <FourGuestForm onSave={onGuestSave} />
            <hr />
            <label>
                페이지 당 표시할 게시물 수:&nbsp;
                <select
                    type="number"
                    value={limit}
                    onChange={({ target: { value } }) => setLimit(Number(value))}
                >
                    <option value="5">5</option>
                    <option value="10">10</option>
                    <option value="20">20</option>
                    <option value="50">50</option>
                    <option value="100">100</option>
                </select>
            </label>

            <main>
                {/* {posts.slice(offset, offset + limit).map(({ id, title, body }) => (
                    <article key={id}>
                        <h3>
                            {id}. {title}
                        </h3>
                        <p>{body}</p>
                    </article>
                ))} */}
                {
                    guestList.slice(offset, offset + limit).map((item, idx) => (
                        <FourGuestRowItem key={idx} item={item}
                            onDelete={onDelete} />
                    ))
                }
            </main>

            <footer>
                <Pagination
                    total={guestList.length}
                    limit={limit}
                    page={page}
                    setPage={setPage}
                />
            </footer>
        </Layout>
    );
}

const Layout = styled.div`
//   display: flex;
//   flex-direction: column;
//   align-items: center;
//   max-width: 800px;
//   margin: 0 auto;
`;

export default FiveApp;