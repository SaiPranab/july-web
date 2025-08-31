import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import Product from './Product'
import products from './products'
import './App.css'

function App() {
  // console.log(products)

  return (
    <>
      {/* {Product()} */}
      {/* <Product></Product> */}

      {/* <Product abc="xyz" brand="Adidas" price="3999.98" description="Very good shoes" />
      <Product brand="Shree Leather" price="4999.97" />
      <Product brand="Puma" price="5999.96" /> */}

      {
        // for (let i = 0; i < products.length; i++) {
        // }

        // console.log(
        //   products.map((p, idx) => {
        //     return <Product brand={p.brand} price={p.price} description={p.description} />
        //   })
        // )

        products.map((p, idx) => 
          <Product brand={p.brand} price={p.price} 
                            description={p.description} key={idx} />)

      }
    </>
  )
}



export default App
