import { createContext, useState } from "react";

const MessageContext = createContext("Helooooooooooooo")

// const [count, setCount] = useState(0) // error -> can only be called inside the body of a functional component
export default function MessageProvider({ children }) {
  const [count, setCount] = useState(110)

  console.log(children, '================')

  return (
    <MessageContext.Provider value={["hiiiiiiiiiii", count, setCount]}>
      <h1>Message Provider</h1>
      {children}
    </MessageContext.Provider>
  )
}

export { MessageContext }