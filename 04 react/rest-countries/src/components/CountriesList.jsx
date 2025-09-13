import React, { useState } from 'react'
import CountryCard from './CountryCard.jsx'

export default function CountriesList({ query }) {
  // let countriesData = []
  const [countriesData, setCountriesData] = useState([])

  if(countriesData.length === 0) {
    fetch('https://restcountries.com/v3.1/all?fields=name,flags,population,region,capital')
      .then((res) => {
        return res.json()
      })
      .then((data) => {
        // console.log('data', data)
        // countriesData = data
        setCountriesData(data)
      })
  }

  console.log('countriesData', countriesData)

  const filteredCountries = countriesData.filter((country) => 
            country.name.common.toLowerCase().includes(query))

  return (
    <>
    <button onClick={() => {setCountriesData([])}}>Remove All Countries</button>

    <div className="countries-container">
      { 
        // filteredCountries.map(
        countriesData.map(
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