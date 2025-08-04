// const numbers = [1, 2, 3, 4, 5]
// console.log(numbers)
// console.log(...numbers)

// const employees = [
//     { name: 'Raj', age: 25 },
//     { name: 'Amit', age: 24 },
//     { name: 'Rakesh', age: 23 },
//     { name: 'Rajesh', age: 22 },
//     { name: 'Rahul', age: 21 },
// ]
// console.log(employees)
// console.log(...employees)

// const myName = 'Sai Pranab Patra'
// console.log(...myName)




// ===========================================================
const arr1 = [10, 20, 30, 40]
let arr2 = [];

for (let i = 0; i < arr1.length; i++) {
    arr2[i] = arr1[i];
}

arr2.push(50)
console.log(arr1)
console.log(arr2)

// ------------------------------------------
const arr3 = [10, 20, 30]
const arr4 = [...arr3, ...'Hello']

// const arr4 = []
// Object.assign(arr4, arr3)

arr4.push(70)
console.log(arr3)
console.log(arr4)

// --------------------------------
const user = {
    name: 'Biswa Bhusan Pradhan',
    age: 24,
}

const copiedUser = { ...user, city: 'BBSR' }
console.log(user)
console.log(copiedUser)