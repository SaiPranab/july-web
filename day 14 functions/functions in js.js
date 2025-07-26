// debugger
console.log("program started")

// fnuction declaration
// syntax => function <function_name> (list of para) {}
function hello() {
    console.log("hello everyone")
}
hello()

function add () {
    const x = 10;
    const y = 20;
    console.log("sum is " + (x + y))
}
add()
// ==================================================


function addTwoNumbers(x = 144, y) {
    console.log("x value is ", x)
    console.log("y value is ", y)
    console.log("addition is", x + y)
}
addTwoNumbers(100, 200)

console.log("program ended")



// =====================================
function substractTwoNumbers(x, y = 23) {
    const res = x - y;
    // console.log("result is ", res)
    return res
}

const result = substractTwoNumbers(10, 20)
console.log("outside the function result is ", result)