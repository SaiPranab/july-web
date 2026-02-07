import { ToastContainer } from "react-toastify"
import { AuthProvider } from "./AuthContext"
import { CartProvider } from "./CartContext"
import CategoryProvider from "./CategoryContext"

export const StoreContextProvider = ({ children }) => {
  return (
    <AuthProvider>
      <CategoryProvider>
        <CartProvider>
          {children}
          <ToastContainer autoClose='2000' position="top-center" />
        </CartProvider>
      </CategoryProvider>
    </AuthProvider>
  )
}