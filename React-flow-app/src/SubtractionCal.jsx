import { useRef } from "react";


function SubtractionCal(){
    const num1Ref=useRef(null);
    const num2Ref=useRef(null);
    const resultRef=useRef(null);
    const handleSubtraction=()=>{
        const num1=parseInt(num1Ref.current.value);
        const num2=parseInt(num2Ref.current.value);
        const sum=num1-num2;
        resultRef.current.value=sum;
    }

    return(
        <div>
            <h1 style={{color:'blue'}}>   Subtraction  of two numbers..</h1>
            <input ref={num1Ref} type="number" placeholder="Enter first number"/>
            <input ref={num2Ref} type="number" placeholder="Enter second number"/>
            <button onClick={handleSubtraction}>Subtraction</button>
            <input ref={resultRef} type="text" placeholder="result" readonly/>

        </div>
    )

}
export default SubtractionCal;