// const s1 = "Raj"
// const s2 = "Amit"
// const s3 = "Chandan"

// const students = ["Raj", "Amit", "Chandan", 10, true, undefined, null, NaN]
// console.log(students);
// console.log(students.length)

// // const fruits = new Array(1000)
// // console.log(fruits)

// // console.log(students[0])
// // console.log(students[1])
// // console.log(students[2])
// // console.log(students[3]) // undefined

// for(let i = 0; i < students.length; i++) {
//     console.log(students[i])
// }

// students[8] = "Dhananjaya"
// console.log(students)

// students[20] = "Rakesh"
// console.log(students)

// students[students.length] = "Mantosh"
// console.log(students)

// students.push("Sai")
// console.log(students)

// const removedStudent = students.pop()
// console.log(removedStudent)
// console.log(students)

// ===========================================================
const fruits = ['Apple', 'Banana', 'Mango']
// console.log(fruits)

// fruits.push('Orange') 
// fruits.pop()

// fruits.unshift('Orange') // adds the element from the front
// fruits.shift() // removesthe lement from the front

// const isMangoIncluded = fruits.includes('Mango')
// console.log(isMangoIncluded)
// const isDatesIncluded = fruits.includes('Dates')
// console.log(isDatesIncluded)

// const moreFruits = ['Pineapple', 'Grapes']
// const addedFruits = fruits.concat(moreFruits)



// fruits.reverse()
// console.log(fruits)

//slice() -> returns a new array, 
const moreFruits = ['Apple', 'Banana', 'Mango', 'Pineapple', 'Grapes', 'litchy', 0, 1, 2, 11, 21]
// let slicedFruits = moreFruits.slice()
//let slicedFruits = moreFruits.slice(2)
// let slicedFruits = moreFruits.slice(2, 4) // ending index is not included
// console.log('morefruits', moreFruits)
// console.log('slicedfruits', slicedFruits)

// splice() -> it deletes the elements in the org array & returns the deleted elements in an new array
// const splicedFruits = moreFruits.splice()
// const splicedFruits = moreFruits.splice(2)
// const splicedFruits = moreFruits.splice(2, 2, "Dates", 'Orange', 'Guava')
// console.log('morefuits', moreFruits);
// console.log('splicedfruits', splicedFruits)

// sort()
// moreFruits.sort()
// moreFruits = 
// console.log('sort', moreFruits)



////////////////////////////////////////////////////////////////////////////
// forEach()
// map()
// filter()
// reduce()
// every()
// some()

const months = ['JAN', 'FEB', 'MAR', 'APR', 'MAY']
// const printMonth = function(value, idx) {
//     console.log("month: ", value, idx)
// }
// const printMonth = (value, idx) => {
//     console.log("month: ", value, idx)
// }
// months.forEach((value, idx) => {
//     console.log("month: ", value, idx)
// })
// function printMonth(value, idx, arr) {
//     console.log("month: ", value, idx, arr)
// }
// function printMonth(value, idx) {
//     console.log("month: ", value, idx)
// }


// Qus -> Diff bet'n map() & forEach()
// const months1 = months.map((value, idx) => {
//     console.log("month: ", value, idx)

//     return true + ":" + idx
// })

// const months2 = months.forEach((value, idx) => {
//     console.log("month: ", value, idx)
// })

// console.log(months1) // we can expect an array - cause map() returns an array
// console.log(months2) // it will be undefined - cause forEach() returns nothing




// const filteredMonths = months.filter(month => {
//     console.log("month: " + month)

//     return month.toLowerCase().includes('m')
// })
// console.log("filtermonths", filteredMonths)

// const students = [
//     { 
//         name: 'Soumya', 
//         roll: 20 
//     },
//     { name: 'Bhabgrahi', roll: 18 },
//     { name: 'Bishal', roll: 22 },
//     { name: 'Viswanatha', roll: 16 }
// ]
// // const rollsGreaterThan18 = students.filter(student => {
// //     return student.roll >= 18
// // })
// const rollsGreaterThan18 = students.filter(student => student.roll >= 18)
// console.log(rollsGreaterThan18)



// reduce(callbackfn, initialValue)
// const nums = [10, 20, 30, 40, 50, 60]
// const result = nums.reduce((accumulator, current, idx, arr) => {
//     console.log(accumulator, current, idx)

//     // return true
//     return true + ":" + idx
// }, 0)
// console.log('result', result) // result value depends upon the last value of the accumulator

// const sum = nums.reduce((acc, current) => acc + current)
// console.log('sum', sum)





// some()
const numbers = [2, 11, 13]
const numbers1 = [11, 13]

let isSomeEvens = numbers.some(num => num % 2 === 0)
console.log(isSomeEvens)

isSomeEvens = numbers1.some(num => num % 2 === 0)
console.log(isSomeEvens)


// every()
let isEveryOdds = numbers1.every(num => num % 2 !== 0)
console.log(isEveryOdds)


// find()