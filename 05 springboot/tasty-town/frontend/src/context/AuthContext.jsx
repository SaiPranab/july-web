import { jwtDecode } from "jwt-decode";
import { createContext, useEffect, useState } from "react";

export const AuthContext = createContext()

export const AuthProvider = ({ children }) => {
  const [token, setToken] = useState(localStorage.getItem('token') || '')
  const [role, setRole] = useState('')

  useEffect(() => {
    if(token) {
      try {
        const { role } = jwtDecode(token)
        setRole(role)
      } catch (err) {
        setToken('')
        setRole('')
        localStorage.removeItem('token')
      }
    }
  }, [token])

  return (
    <AuthContext.Provider value={{ token, setToken, role, setRole}} >
      { children }
    </AuthContext.Provider>
  )
}