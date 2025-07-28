const a = "hello everyone"
console.log(a)

function A() { // outer function
    let x = 10;
    console.log(x)

    function B() { // inner function
        const y = 20;
        console.log(y)
        // console.log(x) // -> This line triggers a clouser


        function C() {
            const z = 30;
            console.log(z)
            console.log(y) // trigger clouser(B)
            console.log(x) // trigger Clouser(A)
            console.log(a)
        }
        C()
    }

    B()
}
// B() // B is not defined as it is local for function A


A()
console.log("program ended")

