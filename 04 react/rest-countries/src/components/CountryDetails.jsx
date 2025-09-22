import { useContext, useEffect, useState } from 'react'
import './CountryDetails.css'
import { Link, useParams } from 'react-router-dom'
import { ThemeContext } from '../store/ThemeContext'
import useWindowSize from '../hooks/useWindowSize'

export default function CountryDetails() {
    const params = useParams()
    const countryName = params.country

    const [notFound, setNotFound] = useState(false)

    const [countryData, setCountryData] = useState(null)

    const {isDark} = useContext(ThemeContext)
    useEffect(() => {
        fetch(`https://restcountries.com/v3.1/name/${countryName}?fullText=true`)
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
                currencies: Object.values(data.currencies).map(curr => curr.name).join(", "),
                languages: Object.values(data.languages).join(', '),
                borders: [],
            })

            if(!data.borders) {
                data.borders = []
            }

            data.borders.map((border) => {
                fetch(`https://restcountries.com/v3.1/alpha/${border}`)
                    .then((res) => {
                        return res.json();
                    })
                    .then(([borderCountry]) => {
                        // console.log("countryyyyyyyyyyyyyyyyy", borderCountry.name.common)
                        console.log('countryDataaaaaaaaaaaaaaaaaaa', countryData)
                        setCountryData((prev) => ({...prev, borders: [...prev.borders, borderCountry.name.common]}) )
                    })
                })
        })
        .catch((err) => {
            console.log("error occurred", err)
            setNotFound(true)
        })
    }, [countryName])

    const windowSize = useWindowSize()

    if(notFound) {
        return <h1>Country Not Found</h1>
    }

    return countryData === null ? <h2>loading....</h2> :
    (<>
        <h1 style={{ textAlign: 'center' }}>{`${windowSize.width} X ${windowSize.height}`}</h1>
        <main className={`${isDark ? "dark" : ""}`}>
            <div className="country-details-container">
                <span className="back-button" onClick={() => history.back()} >
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
                                <b>Currencies: {countryData.currencies}</b>
                                <span className="currencies"></span>
                            </p>
                            <p>
                                <b>Languages: {countryData.languages}</b>
                                <span className="languages"></span>
                            </p>
                        </div>
                        <div className="border-countries">
                            <b>Border Countries: {countryData.borders.map((border) => <Link to={`/${border}`} > {border} </Link>)} </b>&nbsp;
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </>
    )
}