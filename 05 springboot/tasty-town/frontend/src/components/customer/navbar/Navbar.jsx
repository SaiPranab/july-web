// import logo from "../../../assets/images/logo.png"
import { AuthContext } from "@/context/AuthContext";
import { CartContext } from "@/context/CartContext";
import logo from "@assets/images/logo.png";
import { useContext } from "react";
import { Link, NavLink, useNavigate } from "react-router-dom";
import { toast } from "react-toastify";

const Navbar = () => {
  const navigate = useNavigate()

  const { token, role, setToken, setRole } = useContext(AuthContext)
  const { cart } = useContext(CartContext)
  const uniqueItemsInCart = cart?.items?.length || 0

  const handleLogout = (e) => {
    localStorage.removeItem("token")
    setToken("")
    setRole("")
    toast.success("Logout successfull")
    navigate("/")
  }

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

          <div className="d-flex align-items-center gap-4">
            <Link to={"/cart"}>
              <div className="position-relative">
                <img
                  src="/cart.png"
                  alt="Cart"
                  height="28"
                  width="28"
                  className="position-relative"
                />
                <span className="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-primary">
                  { uniqueItemsInCart }
                </span>
              </div>
            </Link>

            { !token ? (
              <>
                <Link to={"/login"} className="btn btn-outline-primary btn-sm">Login</Link>
                <Link to={"/register"} className="btn btn-outline-success btn-sm">Register</Link>
              </>
            ) : (
              <div className="dropdown text-end">
                <a
                  href="#"
                  className="d-block link-body-emphasis text-decoration-none dropdown-toggle"
                  data-bs-toggle="dropdown"
                  aria-expanded="false"
                >
                  <img
                    src="/user.png"
                    alt=""
                    width="32"
                    height="32"
                    className="rounded-circle"
                  />
                </a>

                <ul className="dropdown-menu text-small">
                  { role === "ROLE_ADMIN" && (
                    <Link to={""} className="dropdown-item">Admin Dashboard</Link>
                  )}

                  <Link to={"/myorders"} className="dropdown-item">Orders</Link>
                  <Link onClick={handleLogout} className="dropdown-item">Logout</Link>
                </ul>
              </div>
            )}
          </div>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
