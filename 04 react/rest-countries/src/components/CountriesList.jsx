import React, { useState } from 'react'
import countriesData from '../countriesData.js'
import CountryCard from './CountryCard.jsx'

export default function CountriesList({ query }) {
  const filteredCountries = countriesData.filter((country) => 
            country.name.common.toLowerCase().includes(query))

  return (
    <>
    {/* <input type="text" onChange={(e) => setQuery(e.target.value)} /> */}
    <div className="countries-container">
      { 
        filteredCountries.map(
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