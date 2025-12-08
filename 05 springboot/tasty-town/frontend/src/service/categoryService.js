import axios from "axios"

const BASE_URL = "http://localhost:1200/tasty-town/api/v1/categories"

export const fetchCategories = async () => {
  const response = await axios.get(BASE_URL);
  return response.data;
}