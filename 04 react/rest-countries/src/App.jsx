import Header from './components/Header.jsx'
import './App.css'
import { Outlet } from 'react-router'

function App() {  
  return (
    <>
      <Header />
      <Outlet />
    </>
  )
}

export default App
