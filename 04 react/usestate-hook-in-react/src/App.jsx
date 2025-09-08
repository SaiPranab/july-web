import { useState } from 'react';
import './App.css'

let count = 0;

// const data = useState(0) // [state, setState] = useState(initialValue)

console.log("Hellloooooo")

function App({ root }) {
  // const data = useState(100)
  // console.log('data:-', data)
  
  const [counter, setCounter] = useState(100)
  console.log("rendering", counter)

  const increaseValue = (e) => {
    console.log("Increase button clicked")
    // count++
    // console.log('count:-', count)
    // root.render(<App root={root} />)

    // data[0]++
    // console.log(data[0])
    
    // const setData = data[1]
    // // console.log(setData)
    // setData(data[0]++)
    // console.log(data[0])

    // setCounter(counter + 1)
    // setCounter(100)
    // console.log("Counter Value :-", counter)

    // console.log("Counter Value ", counter)
    // setCounter(counter + 1) // counter = 100, setCounter = 100 + 1 => 101
    // console.log("Counter Value ", counter)
    // setCounter(counter + 1) // counter = 100, setCounter = 100 + 1 => 101
    // console.log("Counter Value ", counter)
    // setCounter(counter + 1) // counter = 100, setCounter = 100 + 1 => 101 
    // console.log("Counter Value ", counter)

    // setCounter((prevState) => {
    //   console.log("1st Previous State is ", prevState)
    //   console.log("1st Counter Value ", counter)
    //   return prevState + 1; 
    // })
    // setCounter((prevState) => {
    //   console.log("2nd Previous State is ", prevState) 
    //   console.log("2nd Counter Value ", counter)
    //   return prevState + 1; 
    // })
    // setCounter((prevState) => {
    //   console.log("3rd Previous State is ", prevState) 
    //   console.log("3rd Counter Value ", counter)
    //   return prevState + 1; 
    // })

    setCounter(prevState => prevState + 1)
    setCounter(prevState => prevState + 1)
    setCounter(prevState => prevState + 1)
  }

  const decreaseValue = (e) => {
    console.log("Decrease button clicked")
  }

  return (
    <>
      <h1>Counter App</h1>

      <button onClick={increaseValue}>Increase</button>
      <br /> <br />
      <button>{counter}</button>
      <br />  <br />
      <button onClick={decreaseValue}>Decrease</button>
    </>
  )
}

export default App
