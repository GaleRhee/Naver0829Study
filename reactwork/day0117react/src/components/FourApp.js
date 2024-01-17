import { Alert } from '@mui/material';
import React from 'react';
import FourGuestForm from './FourGuestForm';

function FourApp(props) {
    return (
        <div>
            <div>
                <Alert severity='primary' variant='filled'>
                    <h3>FourApp - guest db</h3>
                </Alert>
                <FourGuestForm />
            </div>
        </div>
    );
}

export default FourApp;