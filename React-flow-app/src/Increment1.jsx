import { useState } from "react";

function  Increment1()
{
    const[count,setCount]=useState(0)
     return(
         <>
         <h1> This is count value:{count}</h1>
         <button onClick={()=>setCount(count +1)}>Increment</button>
        </>
    )
 }
export default Increment1;