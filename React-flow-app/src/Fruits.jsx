import { useState } from "react";



function Fruits(){

    const[count, setApples] = useState(0)
    
    return (
      <>
      <h1>Number of Apples: {count}</h1>
        {count === 0 ? (
          <p>No apples left</p>
          ): (
         <p>Greate! you have some apples...</p>
      )}
    
      <button onClick={()=>setApples(count + 1)}>Add 1 Apple</button>
      <button onClick={()=> count>0 && setApples(count -1)}>Remove 1 Apple</button>
      <button onClick={()=>setApples(0)}>Resert</button>
      </>
    )
    }export default Fruits;