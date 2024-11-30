import { useState } from "react";


function Increment()
{
   const[count,setCount]=useState(0)
  
   const Increment=()=>{
    setCount(count +1);
   }
   const Decrement=()=>{
    setCount(count +1);
   }

   return(
   <>
   <h1> count values:{count}</h1>
   <button onClick={Increment}>+1</button>
   <button onClick={Decrement}>-1</button>
   </>


   )
};
   export default Increment;