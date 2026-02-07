import axios from "axios"

const BASE_URL = `http://localhost:1200/tasty-town/api/v1/orders`

export const placeOrder = async(data, token) => {
  const response = await axios.post(BASE_URL, data, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })

  return response;
}

export const fetchOrders = async(token) => {
  const response = await axios.get(`${BASE_URL}/user`, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })

  return response;
}

export const fetchAllRecentOrders = async(token) => {
  const response = await axios.get(`${BASE_URL}`, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  })

  return response;
}

export const updateOrderStatus = async(token, orderId, newStatus) => {
  const response = await axios.put(`${BASE_URL}/${orderId}/order/status`,
    null, // No Request Body, cause status is sent in Query Parameter
    {
      params: {
        status: newStatus
      },
      headers: {
        Authorization: `Bearer ${token}`
      }
    }
  );

  return response;
}