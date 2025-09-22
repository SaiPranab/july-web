import React, { useEffect, useState } from 'react'
import CountryCard from './CountryCard.jsx'
import CountryListShimmer from './CountryListShimmer.jsx'

export default function CountriesList({ query }) {
  const [countriesData, setCountriesData] = useState([])

  useEffect(() => {
    fetch('https://restcountries.com/v3.1/all?fields=name,flags,population,region,capital')
      .then((res) => {
        return res.json()
      })
      .then((data) => {
        setCountriesData(data)
      })
  }, [])

  const filteredCountries = countriesData.filter((country) =>
    country.name.common.toLowerCase().includes(query) || country.region.toLowerCase().includes(query)
  )

  if(!countriesData.length) {
    return <CountryListShimmer />
  }

  return (
    <>
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