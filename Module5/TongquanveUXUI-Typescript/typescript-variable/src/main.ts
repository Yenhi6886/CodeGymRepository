// Khai báo biến với kiểu dữ liệu rõ ràng
let userName: string = 'Alice';
let age: number = 20;
const isStudent: boolean = true;

// Khai báo mảng
let numbers: number[] = [1, 2, 3, 4, 5];

// Khai báo object
let student: { id: number; name: string; active: boolean } = {
  id: 1,
  name: 'Alice',
  active: true,
};

// Kiểu dữ liệu any
let randomValue: any = 'Hello';
randomValue = 123;

// Union type
let code: string | number;
code = 101; // ok
code = 'CG-2025'; // ok

console.log('Name:', userName);
console.log('Age:', age);
console.log('Is Student?', isStudent);
console.log('Numbers:', numbers);
console.log('Student:', student);
console.log('Random Value:', randomValue);
console.log('Code:', code);
