import React, { useContext } from 'react';
import { ThemeContext } from './ThemeContext';
import { UserContext } from './UserContext';

const Header = () => {
    const { isDark, doll } = useContext(ThemeContext);
    const user = useContext(UserContext);
    // const { doll } = useContext(ThemeContext);
    return (
        <div>
            <header className='header' style={{ backgroundColor: isDark ? 'black' : 'lightgray' }}>
                <h1>Welcome {user} !!</h1>
                <img alt='' src={require(`../image/${doll}`)}
                    style={{ width: '40px' }} />
            </header>
        </div>
    );
};

export default Header;