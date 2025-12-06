import { useEffect, useState } from "react";
import { fetchFoodImage } from "@service/foodService";
import "./FoodItem.css"

export default function FoodItem({ food }) {
  const [loading, setLoading] = useState(true);
  const [image, setImage] = useState(null)

  const getFoodImage = async (foodImageName) => {
    try {
      const blob = await fetchFoodImage(foodImageName);
      const urlImage = URL.createObjectURL(blob)
      setImage(urlImage);
      setLoading(false);
    } catch (error) {
      console.log("Error fetching food image", error)
      setImage(null);
      setLoading(true)
    }
  }

  useEffect(() => {
    getFoodImage(food.foodImage)
  }, [])

  return (
    <div className="col-12 col-sm-6 col-md-4 col-lg-3 mb-4 d-flex justify-content-center">
      <div className="card food-card-section" >
        <a href={`/food/${food.foodId}`}>
          <img
            src={image}
            className={`${loading ? 'image-hidden' : 'fade-in'} food-image card-img-top`}
            alt="Food Image"
          />
        </a>

        <a href="" className="card-body text-decoration-none">
          <h5 className="card-title">{food.foodName}</h5>
          <p className="card-text">{food.foodDescription}</p>
          <div className="d-flex justify-content-between align-items-center">
            <span className="h5 mb-0">&#8377; {food.foodPrice.toFixed(2)}</span>
          </div>
        </a>
      </div>
    </div>
  );
} 