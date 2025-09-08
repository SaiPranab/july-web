import { useState } from "react"

export default function Greeting({ name }) {
    console.log("Child Component")

    const [clickCount, setClickCount] = useState(0)
    return (
        <div style={{ border: '1px solid gray', padding: '10px', marginTop: '10px' }}>
            <h2>Hello, {name}</h2>
            <p>You clicked the button {clickCount} times</p>
            <button onClick={() => setClickCount((prev) => prev + 1)}>Click Here..</button>
        </div>
    )
} 
