import axios from "axios"

const BASE_URL = "http://localhost:1200/tasty-town/api/v1/categories"

export const fetchCategories = async () => {
  const response = await axios.get(BASE_URL);
  return response.data;
}

export const deleteCategoryById = async (token, categoryId) => {
  const response = await axios.delete(`${BASE_URL}/${categoryId}`, {
    headers: {
      Authorization: `Bearer ${token}`
    }
  });
  return response;
}