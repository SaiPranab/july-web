import { Link } from "react-router-dom"

function CountryCard({ flag, name, population, region, capital}) {
  return (
    // <a className="country-card" href={`/country?name=${name}`}>
    <Link className="country-card" to={`/${name}`}>
      <div className='flag-container'>
        <img src={flag} alt={name + ' Flag'} />
      </div>
      <div className="card-text">
        <h3 className="card-title">{name}</h3>
        <p>
          <b>Population: </b>
          {population.toLocaleString('en-IN')}
        </p>
        <p>
          <b>Region: </b>{region}
        </p>
        <p>
          <b>Capital: </b>{capital}
        </p>
      </div>
    </Link>
  )
}

export default CountryCard