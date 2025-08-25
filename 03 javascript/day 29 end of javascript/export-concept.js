const user = "sai"

// NAMED EXPORT
function greet() {
    console.log("Hello Everyone!!!!!!!!!!")
}

// export { user };
// export { greet };
// export {user, greet} 
export {user, greet as sayHello}


// DEFAULT EXPORT
// export default const name = "Sai" // error it is not the syntax
// const name = "Sai Pranab"
// export default name

 function hello() {
    console.log("Helooooooooooooooooooo")
}

export default hello