import React from 'react'
import B from './B'

const A = () => {
  return (
    <>
      A
      <div style={{
        border: '2px solid black',
        width: '500px',
        height: '300px',
        padding: '30px'
      }}>
        <B message={"Hii"} />
      </div>
    </>
  )
}

export default A