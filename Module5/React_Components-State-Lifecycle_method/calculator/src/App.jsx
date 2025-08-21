import React,{ useState } from "react";

function App() {
  const [num1,setNum1] = useState(0);
  const [num2,setNum2] = useState(0);
  const[result, setResult] = useState(null);

  const calculate = (operator) => {
    const a = parseFloat(num1);
    const b = parseFloat(num2);
    let res;

   
    switch (operator) {
      case "+":
        res = a + b;
        break;
      case "-":
        res = a - b;
        break;
      case "*":
        res = a * b;
        break;
      case "/":
        res = b !== 0 ? a / b : "Không thể chia cho 0";
        break;
      default:
        res = 0;
    }
    setResult(res);
  };



  return (
    <div>
      <input type="number" value={num1} onChange={(e) => setNum1(e.target.value)}/> 
      
      <br/>

      <input type="number" value={num2} onChange={(e) => setNum2(e.target.value)}/> 
      
      <p>Result: {result !== null ? result : ""}</p>

      <div>
        <button onClick={() => calculate("+")}>+</button>
        <button onClick={()=> calculate("-")}>-</button>
        <button onClick={()=> calculate("*")}>*</button>
        <button onClick={()=> calculate("/")}>/</button>
      </div>
    </div>
  );
}

export default App;