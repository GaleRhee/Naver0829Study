import React, { useReducer, useState } from 'react';
import Student from './Student';

//useReducer : state 관리가 용이하며 유지, 보수가 편하다
//호출 : dispatch (type, action) --> reducer (state, action)
//기능
//reducer : state 를 업데이트하는 역할 (은행)
//dispatch - state 업데이트를 요구
//action - 요구의 내용

//reducer 설정 시 초기값으로 미리 지정, id 는 sequence 역할로 delete (filter) 할 때 필요하다
const initialState = {
    count: 2,
    students: [
        {
            id: new Date(),
            name: '이영자',
            isHere: false
        },
        {
            id: new Date(),
            name: '캔디',
            isHere: true
        }
    ]
}

const reducer = (state, action) => {
    switch (action.type) {
        case 'add-student':
            //payload 를 통해서 name 을 전달 받을 것이다
            const name = action.payload.name;
            //추가할 학생 정보 구성
            const addStudent = {
                id: new Date(),
                //name:name,
                name,
                isHere: false
            }

            const data = {
                count: state.count + 1,
                students: [
                    ...state.students,
                    addStudent
                ]
            }
            return data;
        case 'delete-student':
            return {
                count: state.count - 1,
                students: state.students.filter(s => s.id !== action.payload.id)
            };
        case 'mark-student':
            return {
                count: state.count,
                students: state.students.map(s => {
                    if (s.id === action.payload.id) {
                        return {
                            ...s,
                            isHere: !s.isHere
                        }
                    }
                    return s;
                })
            };
        default:
            return state;
    }
}

const ReducerTest2 = () => {
    const [name, setName] = useState('');
    const [studentInfo, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <h5 className='alert alert-danger'>Reducer 예제 #2</h5>
            <h6>Reducer 학생 관리 시스템</h6>
            <h6>총 학생 수 : {studentInfo.count}</h6>
            <div className='input-group' style={{ width: '200px' }}>
                <input type='text' className='form-control'
                    value={name} onChange={(e) => setName(e.target.value)} />
                &nbsp;&nbsp;
                <button type='button'
                    className='btn btn-outline-danger btn-sm'
                    onClick={() => dispatch({ 'type': 'add-student', payload: { name } })}>추가</button>
                <hr />
                {/* payload.name 이 보내진다, 원래 name:name */}
                {
                    studentInfo.students.map((stu, idx) =>
                        <Student key={idx} stu={stu} dispatch={dispatch} />)
                }
            </div>
        </div>
    );
};

export default ReducerTest2;