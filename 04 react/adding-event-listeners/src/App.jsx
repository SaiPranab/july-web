import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const handleClick = (e) => {
    console.log("Hello Everyone");
    console.log(e);
    console.log(e.target);
  }

  function handleDoubleClick() {
    console.log("Paragraph double clicked");
  }

  return (
    <>
      <h1>Adding Event Listeners</h1>

      {/* <p onClick={() => {console.log("Paragraph clicked"); console.log("Paragraph Clicked 2")}}>This is a demo paragraph</p> */}

      <p 
        onMouseEnter={handleClick}
      >Click Here.....</p>
    </>
  )
}

export default App
