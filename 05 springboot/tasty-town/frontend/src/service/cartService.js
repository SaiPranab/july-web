import axios from "axios"

const BASE_URL = `http://localhost:1200/api/v1/cart`

export const getCartOfAnUser = async (token) => {
    const response = await axios.get(BASE_URL, {
        headers: {
            Authorization: `Bearer ${token}`,
        },

    })

    return response;
}