// let / const
const base = [7, 8.5, 9, 6];
let bonus = 1;

// Arrow + map/filter/reduce + ternary
const plusOne = base.map((x) => x + bonus);
const passed = plusOne.filter((x) => x >= 8);
const avg = passed.reduce((a, b) => a + b, 0) / passed.length;
const msg = avg >= 8 ? 'Good' : 'Try harder';
console.log({ avg, msg });

// Destructuring + Spread
const user = { id: 1, name: 'Nhi', city: 'Da Nang' };
const { name, ...rest } = user;
const clone = { ...rest, name: name.toUpperCase() };
console.log(clone);

// Class + field private + arrow method
class Counter {
  #value = 0;
  inc = () => ++this.#value;
  get value() {
    return this.#value;
  }
}
const c = new Counter();
c.inc();
c.inc();
console.log('counter:', c.value);
