import React from 'react'
import countriesData from '../countriesData.js'
import CountryCard from './CountryCard.jsx'

export default function CountriesList() {
  // console.log('.....................', countriesData)
  console.log('.....................', countriesData[0])
  return (
    <div className="countries-container">
      { 
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
  )
}