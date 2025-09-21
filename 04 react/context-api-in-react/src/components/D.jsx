import React, { createContext, useContext } from 'react'
import { MessageContext } from '../store/MessageContext'

const D = () => {
  // const messageContext = useContext(MessageContext);
  // console.log(messageContext, '...................')

  const [msg, count] = useContext(MessageContext);

  return (
    <div style={{textAlign: 'center', fontSize: '40px'}}>{count}</div>
  )
}

export default D