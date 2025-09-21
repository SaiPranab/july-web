import { useContext } from "react"
import { MessageContext } from "../store/MessageContext"

const C = ({ message }) => {
  // const messageContext = useContext(MessageContext);
  // console.log(messageContext[0]);
  // console.log(messageContext[1])
  // console.log(messageContext[2])

  // const [msg, count, setCount] = messageContext

  const [msg, count, setCount] = useContext(MessageContext)
  console.log(msg, count, setCount)

  return (
    <>
      C
      <div style={{
        border: '2px solid black',
        width: '300px',
        height: '100px',
        padding: '30px',
        backgroundColor: 'lightgreen'
      }}>
        {message}
        <br />
        {msg}
        <button onClick={() => setCount(count + 1)}>Increment By 1</button>
      </div>
    </>
  )
}

export default C