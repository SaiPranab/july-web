import { fetchPaginatedFoods } from "@service/foodService";
import { useEffect, useState } from "react"
import FoodDisplay from "../food display/FoodDisplay";

export default ({ title }) => {
  const [foods, setFoods] = useState([]);
  
  const fetchFoods = async () => {
    try {
      const paginatedFoods = await fetchPaginatedFoods(0, 4)
      setFoods(paginatedFoods.content);
    } catch (error) {
      console.log("Error fetching foods ", error)
    }
  }

  useEffect(() => {
    fetchFoods()
  }, [])
  

  return (
    <section className="container-fluid shadow-lg rounded-4 p-4 mb-4">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h4>{ title }</h4>
        <a href="/explore" className="btn btn-outline-primary btn-sm">
          Explore All
        </a>
      </div>

      {/* Food Display */}
      <FoodDisplay foods={foods} />

    </section>
  )
}