import { useState } from 'react'
import './App.css'
import Greeting from './Greeting'

function App() {
  // console.log('Parent compoent ')

  const [name, setName] = useState('Rahul')

  return (
    <div style={{ padding: '20px' }}>
      <h1>React Props Vs States</h1>

      {/* <Greeting name={name} /> */}
      <Greeting name={name}>
        <p>This is extra element passed as <strong>children</strong></p>
        We can pass more elements, text, components etc.
      </Greeting>

      <button style={{ marginTop: '10px' }} onClick={() => { setName((prev) => prev + 1) }}> CLick Me</button>
    </div>
  )
}

export default App
