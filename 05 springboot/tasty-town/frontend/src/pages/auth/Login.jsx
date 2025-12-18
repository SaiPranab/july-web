import React, { useContext, useRef } from "react";
import styles from "./Auth.module.css";
import { Link, useNavigate } from "react-router-dom";
import { login } from "@/service/authService";
import { jwtDecode } from "jwt-decode";
import { AuthContext } from "@/context/AuthContext";
import { toast } from "react-toastify";

const Login = () => {
  const navigate = useNavigate()
  const { setToken, setRole } = useContext(AuthContext)

  const emailRef = useRef();
  const passwordRef = useRef();

  const onSubmitHandler = async (event) => {
    event.preventDefault();

    const postData = {
      userEmail: emailRef.current.value,
      userPassword: passwordRef.current.value
    }

    try {
      const response = await login(postData)

      if (response.status == 200) {
        const { token } = response.data;
        const { role } = jwtDecode(token)

        localStorage.setItem('token', token)
        setToken(token)
        setRole(role)

        toast.success("Login successfull")
        navigate("/")
      } else {
        toast.error("Something went wrong")
      }

    } catch (error) {
      toast.error("Username or Password does not match")
    }
  };

  return (
    <div className={`${styles['login-container']}`}>
      <div className="row">
        <div className="col-sm-9 col-md-7 col-lg-5 mx-auto">
          <div className="card border-0 shadow rounded-3 my-5 fade-slide-in">
            <div className="card-body p-4 p-sm-5">
              <h5 className="card-title text-center mb-5 fw-light fs-5">
                Sign In
              </h5>

              <form onSubmit={onSubmitHandler}>
                <div className="form-floating mb-3">
                  <input
                    type="email"
                    className="form-control"
                    id="floatingInput"
                    placeholder="name@example.com"
                    name="email"
                    ref={emailRef}
                  />
                  <label htmlFor="floatingInput">Email address</label>
                </div>

                <div className="form-floating mb-3">
                  <input
                    type="password"
                    className="form-control"
                    id="floatingPassword"
                    placeholder="Password"
                    name="password"
                    ref={passwordRef}
                  />
                  <label htmlFor="floatingPassword">Password</label>
                </div>

                <div className="d-grid">
                  <button
                    className="btn btn-outline-success btn-login text-uppercase"
                    type="submit"
                  >
                    Sign in
                  </button>

                  <button
                    className="btn btn-outline-danger btn-login text-uppercase mt-2"
                    type="reset"
                  >
                    Reset
                  </button>
                </div>

                <div className="mt-4">
                  Don't have an account? <Link to="/register">Sign up</Link>
                </div>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;