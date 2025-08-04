// const numbers = [11, 21, 31, 41, 51]

// // const a = numbers[0]
// // const b = numbers[1]
// // const c = numbers[2]
// // console.log(a, b, c)

// const [a, b, c, d] = numbers
// console.log(a, b, c, d)

// const [a1, , , , b1] = numbers
// console.log(a1, b1)

// const [a2, b2, ...rest] = numbers
// console.log(a2, b2, rest)


// const numbers1 = [10, 20]
// const [a3, b3, c3 = 999] = numbers1
// console.log(a3, b3, c3)



// =========================Destructuring IN OBJECTS ======================
const employee = {
    id: 101,
    name: 'Raj Kumar',
    age: 25,
    salary: 70000.98
}

// const {a, b} = employee
// console.log(a, b) // undefined, undefined -> as there is no key named 'a' & 'b' in the employee object

const {id: employeeId, name, salary, dept: department = 'IT'} = employee
// console.log(id, name, salary, dept)
// console.log(employeeId, name, salary, dept)
console.log(department)

const {id, ...additionalProperties} = employee
console.log(id, additionalProperties)