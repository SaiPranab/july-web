import { createContext, useContext, useEffect, useState } from "react";
import { AuthContext } from "./AuthContext";
import { getCartOfAnUser } from "@/service/cartService";

export const CartContext = createContext()

export const CartProvider = ({ children }) => {
    const { token } = useContext(AuthContext)
    const [cart, setCart] = useState([])

    useEffect(() => {
        if (!token) return
        initializeCart();
    }, [token])

    async function initializeCart() {
        try {
            const response = await getCartOfAnUser(token);
            if (response.status === 200) {
                setCart(response.data)
            }
        } catch (error) {
            setCart([])
            console.log("Failed to fetch cart", error)
        }
    }

    return (
        <CartContext.Provider value={{ cart, setCart }}>
            {children}
        </CartContext.Provider>
    )
}