import { ToastContainer } from "react-toastify"
import { AuthProvider } from "./AuthContext"
import CategoryProvider from "./CategoryContext"

export const StoreContextProvider = ({ children }) => {
  return (
    <AuthProvider>
      <CategoryProvider>
        {children}
        <ToastContainer autoClose='2000' position="top-center" />
      </CategoryProvider>
    </AuthProvider>
  )
}