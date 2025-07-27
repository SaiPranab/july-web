let x = 10;
const y = 20;

var a = 120

function f1() {
    let b = 220
    var c = 137

    console.log("within function x", x)
    console.log("within function b", b)
}
f1()

    console.log("outside function x", x)
    console.log("outside function b", b)