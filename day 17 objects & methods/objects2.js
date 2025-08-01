const username = "sai"
// console.log(username)

// username = "sipun"
// console.log(username)

const person = {
    firstName: 'Adarsh',
    lastName: 'Singh',
}

// console.log(person.lastName)
// person.lastName = "Sahoo"
// console.log(person.lastName)

// pesosn = {} // error -> as person is declared with const


// let person2 = {
//     firstName: 'Raj',
//     lastName: 'Patra'
// }
// person2 = {} // empty object


// const isDeleted = delete person.lastName
// console.log(isDeleted)
// console.log(person)

// Object.seal(person) // it restrict the Object, so that any addition & deletion of any key can't be possible (still updating key & values are possible)

Object.freeze(person) // through freeze method, we can't make any kind of operation (except extracting values) inside the object