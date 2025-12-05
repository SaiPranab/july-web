// import logo from "../../../assets/images/logo.png"
import logo from "@assets/images/logo.png"

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary">

      <div className="container">
        <a href="/">
          <img src={logo} alt="logo" className="mx-4" height={48} width={48} />
        </a>

        <button className="navbar-toggler" type="button" data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
          aria-label="Toggle navigation">
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <a className="" href="/">
                Home
              </a>
            </li>
            <li className="nav-item">
              <a className="" href="/explore">
                Explore
              </a>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  )
}

export default Navbar;