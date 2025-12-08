import { fetchFoodById, fetchFoodImage } from "@service/foodService";
import { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import styles from "./foodDetails.module.css"

export default function FoodDetails() {
  const { foodId } = useParams()

  const [food, setFood] = useState(null)
  const [image, setImage] = useState(null)
  const [loading, setLoading] = useState(true);

  const getFood = async () => {
    try {
      const fetchedFood = await fetchFoodById(foodId)
      setFood(fetchedFood)
      const blob = await fetchFoodImage(fetchedFood.foodImage);
      const urlImage = URL.createObjectURL(blob)
      setImage(urlImage);

      setLoading(false)
    } catch (error) {
      console.log("Error fetchig food details", error)
      setLoading(true)
    }
  }

  useEffect(() => {
    getFood()
  }, [foodId])

  console.log("/////////////")

  return (
    <section className="py-5">
      <div className="container px-4 px-lg-5 my-5">
        <div className="row gx-4 gx-lg-5 align-items-center">
          <div className="col-md-6">
            <img
              className={`${styles['food-image']} card-img-top rounded-4 img-thumbnail ${loading ? styles.imageHidden : styles.fadeIn}`}
              src={image}
              alt="Food Image"
            />
          </div>
          <div className="col-md-6">
            <div className="fs-5 mb-1">
              Category:
              <span className="badge text-bg-warning">
                {food?.categoryName}
              </span>
            </div>
            <h1 className="display-5 fw-bolder">{food?.foodName}</h1>
            <div className="fs-5 mb-2">
              <span>&#8377; {food?.foodPrice}</span>
            </div>
            <p className="lead">{food?.foodDescription}</p>

            <div className="d-flex align-items-center mb-3">
              <label className="me-2">Quantity:</label>
              <input
                type="number"
                min="1"
                value=""
                onChange=""
                className="form-control w-auto"
              />
            </div>

            <button
              className="btn btn-outline-dark flex-shrink-0"
              type="button"
              onClick={(e) => alert("Item added to cart")}
            >
              <i className="bi-cart-fill me-1"></i>
              Add to cart
            </button>
          </div>
        </div>
      </div>
    </section>
  )
}