
import { useState } from "react";


 

function Buttons(){
    const [count, setCount] = useState(0)

    return(
        <>
            <h1>cricket score: {count}</h1>
            <button style={{color:"red"}} onClick={()=>setCount(count+1)}>+1</button>
            <button style={{color:"red"}} onClick={()=>setCount(count+2)}>+2</button>
            <button style={{color:"red"}} onClick={()=>setCount(count+3)}>+3</button>
            <button style={{color:"red"}} onClick={()=>setCount(count+4)}>+4</button>
            <button style={{color:"red"}} onClick={()=>setCount(count+6)}>+6</button>
            <br></br>
            <button onClick={()=>setCount(0)}>reset</button>
        </>
    )
}
export default Buttons;

