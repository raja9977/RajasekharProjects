import { useRef } from "react";

function Calculator(){
    const num1Ref=useRef(null);
    const num2Ref=useRef(null);
    const resultRef=useRef(null);


    const handleCalculator=()=>
    {
      const num1=parseFloat(num1Ref.current.value);
      const num2=parseFloat(num2Ref.current.value);

    const operation=resultRef.current.value;


    let result;
    switch(operation)
    {
       case "add":
       result=num1+num2;
       case "sub":
        result=num1-num2;
     case "mul":
        result=num1*num2;
        case "div":
            result=num1/num2;

    }
    resultRef.current.value=result;
}
return(
    <div>
        <h1> Calculator..</h1>
        <label> Enter First number</label>
        <input type="number" ref={num1Ref} placeholder="Enter First number"/>
        <input type="number" ref={num2Ref} placeholder="Enter Second number"/>
        <input ref={resultRef} type="text" placeholder='result' readonly/>
        <button onClick={handleCalculator}>Add</button>
        <button onClick={handleCalculator}>sub</button>
        <button onClick={handleCalculator}>mul</button>
        <button onClick={handleCalculator}>div</button>

    </div>
)
}
export default Calculator;