import { createRoot } from 'react-dom/client'
import "bootstrap/dist/css/bootstrap.css"
import "bootstrap/dist/js/bootstrap.bundle.js"
import "bootstrap-icons/font/bootstrap-icons.css"
import './index.css'
import App from './App.jsx'
import { RouterProvider } from 'react-router-dom'
import router from './router'
import CategoryProvider from './context/CategoryContext'
import { AuthProvider } from './context/AuthContext'
import { StoreContextProvider } from './context/StoreContext'

createRoot(document.getElementById('root')).render(
  <StoreContextProvider>
    <RouterProvider router={router} />
  </StoreContextProvider>
)
