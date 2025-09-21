import { createContext, useState } from "react"

export const ThemeContext = createContext()

export default function ThemeProvider({ children }) {
  const [isDark, setIsDark] = useState(JSON.parse(localStorage.getItem("isDarkMode")))

  if (isDark) {
    localStorage.setItem("isDarkMode", true)
  } else {
    localStorage.setItem("isDarkMode", false)
  }

  return (
    <ThemeContext.Provider value={
      {
        isDark,
        setIsDark,
        msg: "Hello everyone"
      }
    }>
      {children}
    </ThemeContext.Provider>
  )
}