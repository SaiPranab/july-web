import { useContext, useState } from "react"
import { ThemeContext } from "../store/ThemeContext"
import { Link } from "react-router-dom"

export default function Header() {
  const { isDark, setIsDark } = useContext(ThemeContext)

  return (
    <header className={`header-container ${isDark ? "dark" : ""}`}>
      <div className="header-content">
        <h2 className="title">
          <Link href="/">Where in the world?</Link>
        </h2>
        <p className="theme-changer" onClick={() => setIsDark(!isDark)}>
          <i className={isDark ? "fa-solid fa-sun" : "fa-regular fa-moon"} />
          &nbsp;&nbsp;{isDark ? 'Light' : 'Dark'} Mode
        </p>
      </div>
    </header>
  )
}
