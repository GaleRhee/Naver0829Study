import axios from 'axios';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import MemberRowItem from './MemberRowItem';


const MemberList = () => {
    const [memberlist, setMemberlist] = useState([]);
    //const [totalCount, setTotalCount] = useState(0);

    //const navi = useNavigate();

    //네이버 스토리지의 이미지 폴더명
    //const imageUrl = process.env.REACT_APP_STORAGE;

    const getMemberlist = () => {
        axios.get("/member/list")
            .then(res => {
                setMemberlist(res.data.mlist);
                //setTotalCount(res.data.totalCount);
            })
    }

    useEffect(() => {
        getMemberlist();
    }, []);

    //삭제 이벤트
    const deleteMember = (num) => {
        const a = window.confirm("삭제하려면 확인을 눌러주세요");
        if (a) {
            const url = "/member/delete?num=" + num;
            axios.delete(url)
                .then(res => {
                    //삭제 성공 후 목록 다시 출력
                    getMemberlist();
                })
        }
    }

    return (
        <div>
            {/* <h4 className='alert alert-danger'>회원 목록 (총 {totalCount}명)</h4> */}
            <h4 className='alert alert-danger'>회원 목록 (총 {memberlist.length}명)</h4>
            <hr />
            <table className='table table-bordered'>
                <tbody>
                    {
                        memberlist &&
                        memberlist.map((row, idx) => (
                            <MemberRowItem key={idx} row={row}
                                deleteMember={deleteMember} />
                        ))
                    }
                </tbody>
            </table>
        </div>
    );
};

export default MemberList;