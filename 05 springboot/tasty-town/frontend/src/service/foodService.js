import axios from "axios"

const BASE_URL = 'http://localhost:1200/tasty-town/api/v1/foods'

export const fetchPaginatedFoods = async (pageNumber = 0, pageSize = 12, filters = {}) => {
  let url = `${BASE_URL}/paginated-foods?page=${pageNumber}&size=${pageSize}`;

  if (filters.categoryId) {
    url += `&catId=${filters.categoryId}`
  }

  if (filters.search) {
    url += `&search=${filters.search}`
  }

  const response = await axios.get(url);
  return response.data;
}

export const fetchFoodImage = async (foodImageName) => {
  const url = `${BASE_URL}/${foodImageName}/image`
  const response = await axios.get(url, {
    responseType: "blob"
  })
  return response.data;
}