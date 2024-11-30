import { useRef } from "react";

function Division(){
    const num1Ref=useRef(null);
    const num2Ref=useRef(null);
    const resultRef=useRef(null);
    const handleDivision=()=>{
        const num1=parseInt(num1Ref.current.value);
        const num2=parseInt(num2Ref.current.value);
        const sum=num1/num2;
        resultRef.current.value=sum;
    }

    return(
        <div>
            <h2>   Division of two numbers..</h2>
            <input ref={num1Ref} type="number" placeholder="Enter first number"/>
            <input ref={num2Ref} type="number" placeholder="Enter second number"/>
            <button onClick={handleDivision}>Add</button>
            <input ref={resultRef} type="text" placeholder="result" readonly/>

        </div>
    )

}
export default Division;