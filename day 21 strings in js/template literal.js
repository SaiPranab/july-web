// template literal (another way of creating the string) 
// syntax -> ``

const a = 10
const b = 20

const str = "value of a: " + 10 + ", b: " + b + ",\nsum of (a+b): " + (a+b)
console.log(str)

const str1 = `value of a: ${a},                      b: ${b},
sum of (a+b): ${a+b + 121}`
console.log(str1)