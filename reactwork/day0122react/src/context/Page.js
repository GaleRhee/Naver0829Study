import React from 'react';
import Header from './Header';
import Content from './Content';
import Footer from './Footer';

const Page = () => {
    return (
        <div>
            {/* 원래는 일일이 isDark 값을 전달해야 했지만 Page 에서 
            Context를 써서 이렇게만 해도 전달된다 */}
            <Header />
            <Content />
            <Footer />
        </div>
    );
};

export default Page;