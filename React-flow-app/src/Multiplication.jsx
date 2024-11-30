import { useRef } from "react";

function Multiplication(){
    const num1Ref=useRef(null);
    const num2Ref=useRef(null);
    const resultRef=useRef(null);
    const handleMultiplication=()=>{
        const num1=parseInt(num1Ref.current.value);
        const num2=parseInt(num2Ref.current.value);
        const sum=num1*num2;
        resultRef.current.value=sum;
    }

    return(
        <div>
            <h2 style={{color:'red'}}>   Multiplication of two numbers..</h2>
            <input ref={num1Ref} type="number" placeholder="Enter first number"/>
            <input ref={num2Ref} type="number" placeholder="Enter second number"/>
            <button onClick={handleMultiplication}>Multiplication</button>
            <input ref={resultRef} type="text" placeholder="result" readonly/>

        </div>
    )

}
export default Multiplication;