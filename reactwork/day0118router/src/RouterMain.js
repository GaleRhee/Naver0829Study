import React from 'react';
import Menu from './components/Menu';
import { Route, Routes } from 'react-router-dom';
import { About, Food, Home } from './pages';


const RouterMain = () => {
    return (
        <div>
            {/* Menu, Home 등등 material 꺼 말고 우리가 만든 걸로 하는 거 주의 */}
            <Menu />
            <hr style={{ clear: 'both' }} />
            < Routes >
                {/* <Route path='/' element={<Home />} /> */}

                {/* Home 에 서브 메뉴를 만들고자 할 경우 */}
                <Route path='/home/*' element={<Home />} />

                {/* <Route path='/about' element={<About />} /> */}

                {/* 파라미터를 보내는 경우 : 방법 1 */}
                {/* :emp 로 Menu.js 의 경로에 적힌 "/about/samsung" 의 samsung 이 emp 값으로 들어간다 */}
                {/* <Route path='/about/:emp' element={<About />} /> */}

                {/* 파라미터를 보내는 경우 : 방법 2 */}
                <Route path='/about' element={<About />}>
                    <Route path=':emp' element={<About />} />
                </Route>

                <Route path='/food' element={<Food />} >
                    <Route path=':food1' element={<Food />} />
                    <Route path=':food1/:food2' element={<Food />} />
                </Route>

                {/* 그 이외에 매핑 주소로 되어 있을 경우 */}
                <Route path='*' element={
                    <div>
                        <h1>잘못된 url 주소야. 내 식사야</h1>
                        <br /><br />
                        <img alt='' src={require(`./image/gomnichiwa.jpg`)} />
                    </div>
                } />
            </Routes>
        </div >
    );
};

export default RouterMain;