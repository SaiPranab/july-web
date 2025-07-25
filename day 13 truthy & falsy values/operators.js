console.log(2 ** 3)
console.log(3 ** 4)

let a = 10;
a **= 3 // a = a ** 3 
console.log(a)
// ======================================


console.log(5 == '5') //('5' coerced -> 5)
console.log(5 === '5') // (no coercion)
console.log(5 === 5) 

console.log(5 != '6') // ('6' coerced -> 6)
console.log(5 !== '6') // (no coercion)
console.log(5 !== '5') // true
console.log(5 != '5') // false ('5' coerced -> 5)
// ==========================================


console.log(2 << 3)  // 2 * 2^3
console.log(64 << 1) // 64 * 2^1

console.log(64 >> 2) // 64 / 2^2
console.log(64 >> 1) // 64 / 2^1