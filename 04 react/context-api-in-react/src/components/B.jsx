import { useContext } from "react"
import C from "./C"
import { MessageContext } from "../store/MessageContext"

const B = ({ message }) => {
  const [msg, count, setCount] = useContext(MessageContext);

  return (
    <>
      B
      <div style={{
        border: '2px solid black',
        width: '400px',
        height: '200px',
        padding: '30px'
      }}>
        <button onClick={() => setCount(count + 2)}>Increment By 2</button>
        <C message={message} />
      </div>
    </>
  )
}

export default B