// import logo from "../../../assets/images/logo.png"
import logo from "@assets/images/logo.png";
import { Link, NavLink } from "react-router-dom";

const Navbar = () => {
  return (
    <nav className="navbar navbar-expand-lg bg-body-tertiary premium-navbar premium-section sticky-top">
      <div className="brand-logo text-center my-3 fade-slide-in">
        <h1 className="logo-text">Tasty Town</h1>
        <p className="logo-tagline">Deliciousness Delivered</p>
      </div>

      <div className="container d-flex align-items-center nav-left-shift">
        <Link to={"/"}>
          <img src={logo} alt="logo" className="mx-4" height={48} width={48} />
        </Link>

        <button
          className="navbar-toggler"
          type="button"
          data-bs-toggle="collapse"
          data-bs-target="#navbarSupportedContent"
          aria-controls="navbarSupportedContent"
          aria-expanded="false"
          aria-label="Toggle navigation"
        >
          <span className="navbar-toggler-icon"></span>
        </button>

        <div className="collapse navbar-collapse" id="navbarSupportedContent">
          <ul className="navbar-nav me-auto mb-2 mb-lg-0">
            <li className="nav-item">
              <NavLink
                className={"nav-link"}
                to={"/"}
              >
                Home
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                className={"nav-link"}
                to={"/explore"}
              >
                Explore
              </NavLink>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
