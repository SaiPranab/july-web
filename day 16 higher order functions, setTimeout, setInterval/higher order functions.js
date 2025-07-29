function f1(cb) {
    console.log("value of cb:", cb)
    console.log("typeof cb:", typeof cb)

    cb()

    return "java Technocrat100"
}

// f1()
// f1(10)
// f1("hello")
// f1(true)

function sayHello() {
    console.log("Hello everyone!!!, Good Morning!")
}

// f1(sayHello()) // -> f1(undefined) // bcz -> sayHello returns nothing

f1(sayHello)

console.log(1)
console.log(2)
console.log(3)

function f2(cb) {
    f1(sayHello)
} 

f2(f1)