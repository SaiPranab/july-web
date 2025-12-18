import { useRef } from "react"
import styles from "./Auth.module.css"
import { Link, useNavigate } from "react-router-dom"
import { toast } from "react-toastify"
import { register } from "@/service/authService"

export default function Register() {
  const navigate = useNavigate()

  const nameRef = useRef()
  const emailRef = useRef()
  const passwordRef = useRef()

  const onSubmitHandler = async (e) => {
    e.preventDefault();

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
                  />
                  <label for="floatingName">Full Name</label>
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
                  />
                  <label for="floatingInput">Email</label>
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
                  />
                  <label for="floatingPassword">Password</label>
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
                  >
                    Reset
                  </button>
                </div>

                <div class="mt-4">
                  Already have an account?
                  <Link href="/login">Sign In</Link>
                </div>
              </form>

            </div>
          </div>
        </div>
      </div>
    </div>
  )
}