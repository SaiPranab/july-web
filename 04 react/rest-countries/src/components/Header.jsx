import { useState } from "react"

export default function Header() {
  const [isDark, setIsDark] = useState(localStorage.getItem("isDarkMode"))

  if (isDark) {
    document.body.classList.add('dark')
    localStorage.setItem("isDarkMode", true)
  } else {
    document.body.classList.remove('dark')
    localStorage.setItem("isDarkMode", false)
  }

  return (
    <header className="header-container">
      <div className="header-content">
        <h2 className="title">
          <a href="/">Where in the world?</a>
        </h2>
        <p className="theme-changer" onClick={() => setIsDark(!isDark)}>
          <i className={isDark ? "fa-solid fa-sun" : "fa-regular fa-moon"} />
          &nbsp;&nbsp;{isDark ? 'Light' : 'Dark'} Mode
        </p>
      </div>
    </header>
  )
}
