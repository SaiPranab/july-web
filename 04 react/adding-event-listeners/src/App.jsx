import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const handleClick = (e, name) => {
    console.log("Hello Everyone");
    console.log('e', e);
    console.log('name', name)
    // console.log(e.target);
  }

  function handleDoubleClick() {
    console.log("Paragraph double clicked");
  }

  function handleInputChange(e) {
    console.log("Input value changed")
    // console.log(e)
    // console.log(e.target)
    console.dir(e.target.value)
  }

  return (
    <>
      <h1>Adding Event Listeners</h1>

      {/* <p onClick={() => {console.log("Paragraph clicked"); console.log("Paragraph Clicked 2")}}>This is a demo paragraph</p> */}

      <p
        onMouseEnter={handleClick}
      >Click Here.....</p>

      <input type="text" onChange={handleInputChange} />

      <br /> <br />
      <button onClick={(e) => handleClick(e, "Java Technocrat")}>Click Here!!!</button>
      <br /> <br />
      <button onClick={handleClick("fsjhgbdjhfbg")}>Click Here 2</button>
    </>
  )
}

export default App
