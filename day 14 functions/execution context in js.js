var username = 'Abhishek'
var userAge = 22

sayHello()

function sayHello() {
    console.log(username, "say's Hello")
}

// sayHello()


// function expression
// add(121, 212)
const add = function(x, y) {
    let abc = 'something'
    const bcd = "something"

    console.log("addition is ", x + y)
} 
add(121, 212)