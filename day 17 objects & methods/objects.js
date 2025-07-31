// const user = {

// }

// console.log(user)
// console.log(typeof user)

let username = 'Ankit'

const user = {
    firstName: 'Adarsh',
    lastName: 'Singh',

    'full-Name': 'Adarsh Singh',

    age: 23,

    isGraduated: true
}

// GET VALUES //
console.log(username)
// console.log(firstName)

console.log(user.firstName)
console.log(user['lastName'])

// console.log(user.full-Name) // erro
console.log(user['full-Name'])

let age2 = 'age'
console.log(user.age2)
console.log(user[age2])



// UPDATE VALUES //
console.log(user.isGraduated)
user.isGraduated = false
console.log(user.isGraduated)
// console.log(user)


// ADD VALUES //
console.log(user.mobileNumber) // undefined
user.mobileNumber = 9876543210
console.log(user.mobileNumber)






// Nested Objects 
const user2 = {
    firstName: 'Adarsh',
    lastName: 'Singh',
    'full-Name': 'Adarsh Singh',
    age: 23,
    isGraduated: true,

    address: {
        city: 'BBSR',
        pin: 751007,
        isRental: false
    },

    // function greet() {
    //     console.log("user says Hello")
    // }
    greet: function () {
        console.log('user says hello')

        // return undefined
        // return 100
        return "SAI"
    },

    showNameAndMsg: function (name, msg) {
        // return "Hello " + name + " , your msg is " + msg
        return; // -> although we've not written anything but it returns undefined
    }
}

console.log(user2)
console.log(user2.address.city)
user2.address.city = "CTC"
console.log(user2.address.city)

console.log('state', user2.address.state) // undefined
// console.log(user2.greet2())
console.log(user2.greet())

// console.log(user2.showNameAndMsg("Amiya", "Good morning"))
const x = user2.showNameAndMsg('Amiya', 'Good morning')
console.log(x + "asnfbjhad"+'dsfjhvjashdvf')
