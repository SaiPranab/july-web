import { useState } from "react"
// import './Greeting.css'
// import './Greeting.module.css'
import styles from './Greeting.module.css'
console.log('styles', styles)

export default function Greeting({ name, children }) {
    // console.log("Child Component")

    // console.log(children)

    const [clickCount, setClickCount] = useState(0)
    return (
        <div style={{ border: '1px solid gray', padding: '10px', marginTop: '10px' }}>
            <h2 className={styles['text-xl']} >Hello, {name}</h2>
            <p>You clicked the button {clickCount} times</p>
            {/* <button className="button" onClick={() => setClickCount((prev) => prev + 1)}>Click Here..</button> */}

            <button className={styles.button} onClick={() => setClickCount((prev) => prev + 1)}>Click Here..</button>
            <div style={{ marginTop: '10px', padding: '10px', backgroundColor: '#f06969ff' }}>
                {children}
            </div>
        </div>
    )
} 
