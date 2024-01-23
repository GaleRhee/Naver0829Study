import React from 'react';
import mainImage1 from '../image/04.png';
import mainImage2 from '../image/08.png';

const Home = () => {
    return (
        <div>
            <h1>React + SpringBoot Project</h1>
            <img alt='' src={mainImage1}
                style={{ width: '300px', margin: '10px', border: '5px groove orange' }} />
            <img alt='' src={mainImage2}
                style={{ width: '300px', margin: '10px', border: '5px groove orange' }} />
        </div>
    );
};

export default Home;