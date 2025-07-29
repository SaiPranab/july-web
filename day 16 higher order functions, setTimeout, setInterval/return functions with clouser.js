// const a = 10;

// const outer = function () {
//     const b = 20;
//     const x = 110;

//     const add = function () {
//         console.log("addition is ", a + b)
//     }

//     // add() // calling
//     return add;

//     // return true
// }

// const func = outer()
// // console.log('func', func)
// // console.dir(func)
// func()


function f1() {
    let firstName = "Ashutosh"
    let lastName  = "Sahoo"

    function f2() {
        console.log("first name is ", firstName)
    }

    return f2;
}

const printName = f1()
// console.log("printName value", printName)
printName()