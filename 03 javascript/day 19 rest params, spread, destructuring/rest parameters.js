// function add(a, b) {

// const add = function(a, b) {

// const add = (a, b) => // error - as arguements keyword is not supported in arrow functions

// function add(a, b) {
//     console.log(a + b)
//     console.log('arguements', arguments)

//     // arguments.forEach(() => console.log("hello"))
//     console.log(arguments.length)

//     let sum = 0
//     for (let i = 0; i < arguments.length; i++) {
//         // console.log(arguments[i])
//         sum += arguments[i]
//     }
//     console.log('sum is', sum)
// }

// add(10, 20, 30, 40, 50)



// rest params -> ...args
// const sum = (...args, a, b ) => {       
// const sum = (a, b, ...args) => {
//     console.log("sum of (a+b):", a + b)

//     console.log(args)
//     console.log(args.length)
//     const sum = args.reduce((acc, current) => acc + current)
//     console.log("sum of rest params", sum)
// }
// sum(10, 20, 30, 40, 50)



function printMessages(...params) {
    params.forEach(msg => console.log(msg))
}
printMessages('Hii', 'Hello', 'Bye', 'Good Bye', 'tata', 'Gaya', 'Khatam')