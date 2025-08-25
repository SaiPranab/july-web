// const str = "      Hello World       "

// console.log(str.toUpperCase())
// console.log(str)

// const lowerStr = str.toLowerCase()
// console.log(str, "->", lowerStr)

// const bothSideTrim = str.trim()
// console.log(str, "->", bothSideTrim)

// const startTrim = str.trimStart()
// console.log(str, '->', startTrim)


// ======================================
const str = 'JavaScripta'

console.log(str.charAt(4)) // S
console.log(str[4]) // S

console.log(str.charCodeAt(4))


const str1 = str.concat(' is fun!')
console.log(str, "->", str1)


console.log(str.includes('a')) 
const letter = 'A'
console.log(str.includes(letter.toLowerCase())) 
console.log(str.includes('Script'))

console.log(str.indexOf('a'))
console.log(str.indexOf('a', 2))
console.log(str.lastIndexOf('a'))

const replacedString = str.replace("a", "k")
console.log(str, "->", replacedString)

const replaceAllStr = str.replaceAll("a", "k")
console.log(str, "->", replaceAllStr)

console.log(str.repeat(3))

console.log('5'.padStart(3, '0'))
console.log(str.padStart(15, "0"))

console.log('5'.padEnd(3, '0'))
console.log(str.padEnd(15, "0"))

const fruitsStr = 'apple,banana,cherry,mango, orange'
const fruuitsArr = fruitsStr.split(',')
console.log(fruitsStr, '->', fruuitsArr)

const s = 'we are developers'
console.log(s.length)

console.log(s.slice())
console.log(s.substring())

console.log(s.slice(10))
console.log(s.substring(10))

console.log(s.slice(-9))
console.log(s.substring(-9)) // -9 => 0

console.log(s.slice(17)) // ""
console.log(s.substring(17)) // ""

console.log(s.slice(11, 13))
console.log(s.substring(11, 13)) 

console.log(s.slice(13, 11)) // if (st > en) => ""
console.log(s.substring(13, 11)) // if (st > en) -> swap => substring(11, 13)

console.log(s.slice(-6, -2))  // lope
console.log(s.substring(-6, -2)) // ""

console.log(s.slice(-6, 2)) // slice(11, 2) => ""
console.log(s.substring(-6, 2)) // substring(0, 2)

console.log(s.slice(2, -6)) // 
console.log(s.substring(2, -6)) // => substring(2, 0) => substring(0, 2)

s.substr