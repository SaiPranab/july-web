import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import App from './App.jsx'
import { createBrowserRouter, RouterProvider } from "react-router";

const router = createBrowserRouter([
  {
    path: '/',
    element: <h1>Hello React Router</h1>
  },
  {
    path: '/abc',
    element: <p>This is a random paragraph</p>
  },
])

createRoot(document.getElementById('root')).render(
  // <StrictMode>
    // <App />
  // </StrictMode>,
  <RouterProvider router={router} />
)
