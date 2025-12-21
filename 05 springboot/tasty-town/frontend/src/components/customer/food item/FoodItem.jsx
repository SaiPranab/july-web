import { useContext, useEffect, useState } from "react";
import { fetchFoodImage } from "@service/foodService";
import "./FoodItem.css";
import { Link } from "react-router-dom";
import { CartContext } from "@/context/CartContext";
import { AuthContext } from "@/context/AuthContext";
import { addToCart, updateItemQuantity } from "@/service/cartService";
import { toast } from "react-toastify";

export default function FoodItem({ food }) {
  const [loading, setLoading] = useState(true);
  const [image, setImage] = useState(null);

  const { token } = useContext(AuthContext)
  const { cart, setCart } = useContext(CartContext)
  const cartItems = cart?.items || []
  const cartItem = cartItems.find(item => item.foodId === food.foodId)
  const quantity = cartItem?.quantity

  const getFoodImage = async (foodImageName) => {
    try {
      const blob = await fetchFoodImage(foodImageName);
      const urlImage = URL.createObjectURL(blob);
      setImage(urlImage);
      setLoading(false);
    } catch (error) {
      console.log("Error fetching food image", error);
      setImage(null);
      setLoading(true);
    }
  };

  const increaseQty = async () => {
    try {
      const newQuantity = quantity + 1;
      const postData = {
        foodId: food.foodId,
        quantity: newQuantity
      }
      const response = await updateItemQuantity(postData, token)

      if (response.status === 200) {
        const updatedItems = cartItems.map(item => (
          item.foodId === food.foodId ? { ...item, quantity: newQuantity } : item
        ))
        setCart({ ...cart, items: updatedItems })
      } else {
        toast.error("Something went wrong")
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }

  const decreaseQty = async () => {
    try {
      const newQuantity = quantity - 1;
      if (newQuantity < 0) {
        toast.error("Something went wrong")
        return;
      }

      const postData = {
        foodId: food.foodId,
        quantity: newQuantity
      }
      const response = await updateItemQuantity(postData, token)

      if (response.status === 200) {
        const updatedItems = cartItems.map(item => (
          item.foodId === food.foodId ? { ...item, quantity: newQuantity } : item
        ))

        const filteredItems = updatedItems.filter(item => item.quantity >= 1)
        setCart({ ...cart, items: filteredItems })
      } else {
        toast.error("Something went wrong")
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }

    const handleAddItemToCart = async (e) => {
      if(!food.foodId) {
        toast.info("Please select a food")
        return
      }
  
      const postData = {
        foodId: food.foodId,
        quantity: 1
      }
  
      try {
        const response = await addToCart(postData, token)
        if(response.status === 200) {
          toast.success("Item added to cart")
          setCart(response.data)
        }
      } catch (error) {
        toast.error("Something went wrong")
      }
    }

  useEffect(() => {
    getFoodImage(food.foodImage);
  }, []);

  return (
    <div className="col-12 col-sm-6 col-md-4 col-lg-3 mb-4 d-flex justify-content-center text-decoration-none">
      <div className="card food-card-section">
        <Link to={`/food/${food.foodId}`} >
          <img
            src={image}
            className={`${loading ? "image-hidden" : "fade-in"
              } food-image card-img-top`}
            alt="Food Image"
          />
        </Link>

        <div className="card-body text-decoration-none">
          <h5 className="card-title">{food.foodName}</h5>
          <p className="card-text">{food.foodDescription}</p>

          <div className="d-flex justify-content-between align-items-center mt-2">
            <span className="price-badge">
              &#8377; {food.foodPrice.toFixed(2)}
            </span>
            {/* <a
                href={`/food/${food.foodId}`}
                className="btn btn-sm btn-outline-primary"
              >
                View
              </a> */}

            {/* <!-- handle If Cart does not conatins this food item --> */}
            {
              !quantity ? (
                <button onClick={handleAddItemToCart}
                  className="btn btn-sm btn-outline-primary rounded-pill px-3" >
                  Add
                </button>
              ) : (
                <div className="d-flex align-items-center gap-2 bg-light rounded-pill p-1 border">
                  <button onClick={decreaseQty}
                    className="btn btn-sm btn-light rounded-circle p-0 d-flex align-items-center justify-content-center text-primary"
                    style={{ width: '24px', height: '24px' }}
                  >
                    <i className="bi bi-dash"></i>
                  </button>
                  <span className="fw-bold small px-1">
                    {quantity}
                  </span>
                  <button onClick={increaseQty}
                    className="btn btn-sm btn-primary rounded-circle p-0 d-flex align-items-center justify-content-center text-white"
                    style={{ width: '24px', height: '24px' }}
                  >
                    <i className="bi bi-plus"></i>
                  </button>
                </div>

              )
            }
          </div>
        </div>
      </div>
    </div>
  );
}
