import { useState } from 'react';
import './App.css'

let count = 0;

// const data = useState(0) // useState(initialValue)

function App({ root }) {
  // const data = useState(100)
  // console.log('data:-', data)

  const [counter, setCounter] = useState(100)

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

    setCounter(counter + 1)
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
