import React from 'react';
import { useState } from 'react';

const Counter = () => {

    const [counter, setCounter] = useState(0);
    const [input, setInput] = useState('');

    return (
        <div>
            <h2 style = { { color : 'aqua'} } > Counter {counter} </h2>
            <button onClick = { () => setCounter(counter+1) }>Increase</button>
            <br></br>
            <br></br>
            <button onClick = { () => setCounter(counter-1) }>Decrease</button>
            <input type="text" value={input} onChange={(e) => setInput(e.target.value)}></input>
            <h2> <b> {input} </b></h2>
        </div>
    )
}

export default Counter
