// function fibonacci(n: number): number {
//   if (n <= 1) {
//     return n;
//   }
//   return fibonacci(n - 1) + fibonacci(n - 2);
// }

// let count = 10;  
// let sum = 0;

// console.log("Dãy Fibonacci:");
// for (let i = 0; i < count; i++) {
//   let num = fibonacci(i);
//   console.log(num);
//   sum += num;
// }

// console.log("Tổng các số Fibonacci:", sum);

function fibonacci(n:number) : number {

if(n<=1) {
    return n;
}
return fibonacci(n-1)+ fibonacci(n-2);
}

let count = 10;
let sum = 0;
 
console.log("Day fibonacci:");
for( let i =0;i<count; i++) {
    let num = fibonacci(i);
    console.log(num);
    sum +=num;
    
}

console.log("Tong cac so Fibonacci:",sum);