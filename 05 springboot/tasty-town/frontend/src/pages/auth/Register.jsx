import { useRef, useState } from "react"
import styles from "./Auth.module.css"
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify"
import { register } from "@/service/authService"

export default function Register() {
  const navigate = useNavigate()

  const nameRef = useRef()
  const emailRef = useRef()
  const passwordRef = useRef()

  const [errors, setErrors] = useState({})

  const validateForm = () => {
    const newErrors = {}

    const name = nameRef.current.value.trim()
    const email = emailRef.current.value.trim()
    const password = passwordRef.current.value.trim()

    if(!name){
      newErrors.name = "Name is required"
    } else if(name.length < 3) {
      newErrors.name = "Name must be atleast 3 characters"
    } else if(name.lngth > 50) {
      newErrors.name = "Name cannot be greater than 50 chracters"
    }
      
    const emailRegex = /^[^@]+@[^@]+\.[^@]+$/
    if(!email) {
      newErrors.email = "Email is required"
    } else if(!emailRegex.test(email)) {
      newErrors.email = "Invalid email address"
    } 
    
    const passwordRegex = /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[!@#$%^&*]).{8,}$/;
    if(!password) {
      newErrors.password = "Password is required"
    } else if(password.length < 8) { 
      newErrors.password = "Password must be at least 8 characters"
    } else if (! passwordRegex.test(password)) {
      newErrors.password = "Password must contain uppercase, lowercase and number"
    }

    setErrors(newErrors)
    return Object.keys(newErrors).length === 0
  }

  const clearFieldError = (field) => {
    setErrors((prev) => ({
      ...prev,
      [field]: ""
    }))
  }

  const onSubmitHandler = async (e) => {
    e.preventDefault();

    if(!validateForm()) return;

    const postData = {
      username: nameRef.current.value,
      userEmail: emailRef.current.value,
      userPassword: passwordRef.current.value
    }

    try {
      const response = await register(postData);
      if(response.status === 201) {
        toast.success("Registration Completed. Please Login")
        navigate("/login")
      } else {
        toast.error("Something went wrong")
      }
    } catch( err ) {
      toast.error("unable to register. Please try again")
    }
  }

  const onResetHandler = async (e) => {
    setErrors({})
  }

  return (
    <div class={`${styles['register-container']}`}>
      <div class="row">
        <div class="col-sm-9 col-md-7 col-lg-5 mx-auto">
          <div class="card border-0 shadow rounded-3 my-5 fade-slide-in">
            <div class="card-body p-4 p-sm-5">
              <h5 class="card-title text-center mb-5 fw-light fs-5">
                Sign Up
              </h5>

              <form onSubmit={onSubmitHandler}>
                <div class="form-floating mb-3">
                  <input
                    type="text"
                    class="form-control"
                    id="floatingName"
                    placeholder="John Doe"
                    name="name"
                    required
                    ref={nameRef}
                    onChange={() => clearFieldError("name")}
                  />
                  <label for="floatingName">Full Name</label>
                  { errors.name && (
                    <p className="invalid-feedback d-block">{errors.name}</p>
                  )}
                </div>

                <div class="form-floating mb-3">
                  <input
                    type="email"
                    class="form-control"
                    id="floatingInput"
                    placeholder="name@example.com"
                    name="email"
                    required
                    ref={emailRef}
                    onChange={() => clearFieldError("email")}
                  />
                  <label for="floatingInput">Email</label>
                  { errors.email && (
                    <p className="invalid-feedback d-block">{errors.email}</p>
                  )}
                </div>

                <div class="form-floating mb-3">
                  <input
                    type="password"
                    class="form-control"
                    id="floatingPassword"
                    placeholder="Password"
                    name="password"
                    required
                    ref={passwordRef}
                    onChange={() => clearFieldError("password")}
                  />
                  <label for="floatingPassword">Password</label>
                  { errors.password && (
                    <p className="invalid-feedback d-block">{errors.password}</p>
                  )}
                </div>

                <div class="d-grid">
                  <button
                    class="btn btn-outline-primary btn-login text-uppercase"
                    type="submit"
                  >
                    Sign up
                  </button>

                  <button
                    class="btn btn-outline-danger btn-login text-uppercase mt-2"
                    type="reset"
                    onClick={onResetHandler}
                  >
                    Reset
                  </button>
                </div>

                <div class="mt-4">
                  Already have an account?
                  <Link to={"/login"}>Sign In</Link>
                </div>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  )
}