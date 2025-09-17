import { useEffect, useState } from 'react'
import './CountryDetails.css'

export default function CountryDetails() {
    const [countryData, setCountryData] = useState(null)
    useEffect(() => {
        fetch(`https://restcountries.com/v3.1/name/India?fullText=true`)
        .then((res) => {
           return res.json()
        })
        .then(([data]) => {
            console.log('data', data)
            setCountryData({
                flag: data.flags.svg,
                name: data.name.common,
                nativeName: Object.values(data.name.nativeName)[0].common,
                population: data.population.toLocaleString('en-IN'),
                region: data.region,
                subregion: data.subregion,
                capital: data.capital.join(', '),
                tld: data.tld.join(', '),
                // currencies: ''
            })
        })
        .catch((err) => {
            console.log("error occurred", err)
        })
    }, [])

    return countryData === null ? <h2>loading....</h2> :
    (
        <main>
            <div className="country-details-container">
                <span className="back-button">
                    <i className="fa-solid fa-arrow-left"></i>&nbsp; Back
                </span>
                <div className="country-details">
                    <img src={countryData.flag} alt="#" />
                    <div className="details-text-container">
                        <h1>Country Name: {countryData.name}</h1>
                        <div className="details-text">
                            <p>
                                <b>Native Name: {countryData.nativeName}</b>
                                <span className="native-name"></span>
                            </p>
                            <p>
                                <b>
                                    Population: {countryData.population}
                                </b>
                                <span className="population"></span>
                            </p>
                            <p>
                                <b>Region: {countryData.region}</b>
                                <span className="region"></span>
                            </p>
                            <p>
                                <b>Sub Region: {countryData.subregion}</b>
                                <span className="sub-region"></span>
                            </p>
                            <p>
                                <b>Capital: {countryData.capital}</b>
                                <span className="capital"></span>
                            </p>
                            <p>
                                <b>Top Level Domain: {countryData.tld}</b>
                                <span className="top-level-domain"></span>
                            </p>
                            <p>
                                <b>Currencies: </b>
                                <span className="currencies"></span>
                            </p>
                            <p>
                                <b>Languages: </b>
                                <span className="languages"></span>
                            </p>
                        </div>
                        <div className="border-countries">
                            <b>Border Countries: </b>&nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </main>
    )
}