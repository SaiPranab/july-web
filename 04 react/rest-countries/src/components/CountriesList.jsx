import React, { useEffect, useState } from 'react'
import CountryCard from './CountryCard.jsx'

export default function CountriesList({ query }) {
  console.log("rendering")
  // let countriesData = []
  const [countriesData, setCountriesData] = useState([])

  // if(countriesData.length === 0) {
  //   fetch('https://restcountries.com/v3.1/all?fields=name,flags,population,region,capital')
  //     .then((res) => {
  //       return res.json()
  //     })
  //     .then((data) => {
  //       // console.log('data', data)
  //       // countriesData = data
  //       setCountriesData(data)
  //     })
  // }

  useEffect(() => {
    // console.log("111111111111111111111111")
    fetch('https://restcountries.com/v3.1/all?fields=name,flags,population,region,capital')
      .then((res) => {
        return res.json()
      })
      .then((data) => {
        // console.log('data', data)
        // countriesData = data
        setCountriesData(data)
      })
  }, [])
  /**
   * [] -> defines useEffect will only be executed on first render (mount)
   * [states] -> useEffect again executed if the dependency state has been changed
   * if dependency array is not available then useEffect will be executed on every re-render
   * 
   * for some cleanup purposes
   */
  // console.log('countriesData', countriesData)

  // const [count, setCount] = useState(0)
  // useEffect(() => {
  //   console.log("2222222222222222")
  // }, [count])

  // useEffect(() => {
  //   console.log("3333333333333333")/
  // })

  useEffect(() => {
    console.log("444444444444444444")
    const id = setInterval(() => console.log("Interval executing in every 2 seconds"), 2000)

    return () => {
      console.log("Cleaning up......")
      clearInterval(id)
    }
  }, [])

  const filteredCountries = countriesData.filter((country) =>
    country.name.common.toLowerCase().includes(query))

  return (
    <>
      {/* <button onClick={() => { setCount(count + 1) }}>Increment</button> */}
      <button onClick={() => { setCountriesData([]) }}>Remove All Countries</button>

      <div className="countries-container">
        {
          filteredCountries.map(
          // countriesData.map(
            (country, idx) =>
              <CountryCard
                key={idx}
                flag={country.flags.svg}
                name={country.name.common}
                population={country.population}
                region={country.region}
                capital={country.capital[0]}
              />
          )
        }
      </div>
    </>
  )
}