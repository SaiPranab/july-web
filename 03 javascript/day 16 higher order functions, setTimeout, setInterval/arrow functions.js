// <const, let> <variable_name> = function () {}

// <const, let> <variable_name> = (list of params) => { // body}

// const sayHello = fullname => {
//     console.log(fullname, "says, Good Morning everyone!!!")
// }

// const sayHello = (fullname, lastName = "lastname") => {
//     console.log(fullname, lastName, "says, Good Morning everyone!!!")
// }

// const sayHello = fullname => console.log(fullname, "says, Good Morning everyone!!!")

// sayHello()
// sayHello("Bhabagrahi")


// function square( num ) {
//     console.log(num * num)
// }
// const square = num => console.log(num * num)

const square = num => num * num;

const square2 = num => {
    return num * num;
}

const number = prompt('Enter a number')
console.log(square(parseInt(number)))
console.log(square2(5))