import React from 'react';

function DateTime() {
    const now = new Date(); 
    const currentDate = now.toDateString(); 
    const currentTime = now.toLocaleTimeString(); 

    return (
        <>
            <h2>Date: {currentDate}</h2>
            <h2>Time: {currentTime}</h2>
            <h2>D & T: {currentDate}  {currentTime}</h2>
        </>
    );
}

export default DateTime;