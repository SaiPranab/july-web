function CountryListShimmer() {
  return (
    <div className="countries-container">
      {
        Array.from({ length: 20}).map((el, i) => 
          <div key={i} className="country-card shimmer-card">
            <div className="flag-container"></div>
            <div className="card-text">
              <h3 className="card-title"></h3>
              <p></p>
              <p></p>
              <p></p>
            </div>
          </div>
        )
      }
    </div>
  )
}

export default CountryListShimmer