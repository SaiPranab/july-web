import axios from "axios"

const BASE_URL = `http://localhost:1200/tasty-town/api/v1/cart`

export const getCartOfAnUser = async (token) => {
    const response = await axios.get(BASE_URL, {
        headers: {
            Authorization: `Bearer ${token}`,
        },

    })

    return response;
}

export const addToCart = async (data, token) => {
    const response = await axios.post(BASE_URL, data, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })

    return response
}

export const updateItemQuantity = async (data, token) => {
    const response = await axios.put(BASE_URL, data, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })

    return response
}

export const removeItem = async (foodId, token) => {
    const response = await axios.delete(`${BASE_URL}/${foodId}/food`, {
        headers: {
            Authorization: `Bearer ${token}`
        }
    })

    return response
}