import { useContext } from "react"
import "./cart.css"
import { CartContext } from "@/context/CartContext"
import { AuthContext } from "@/context/AuthContext"
import { Link } from "react-router-dom"
import { toast } from "react-toastify"
import { updateItemQuantity, removeItem } from "@/service/cartService"
import { calculateCartTotals } from "@/utils/cartUtils"

export default function Cart() {
  const { token } = useContext(AuthContext)
  const { cart, setCart } = useContext(CartContext)
  const cartItems = cart?.items || []

  const { subTotal, shippingCharge, tax, total } = calculateCartTotals(cartItems)

  const increaseQty = async (foodId, quantity) => {
    try {
      const newQuantity = quantity + 1;
      const postData = {
        foodId,
        quantity: newQuantity
      }
      const response = await updateItemQuantity(postData, token)

      if (response.status === 200) {
        const updatedItems = cartItems.map(item => (
          item.foodId === foodId ? { ...item, quantity: newQuantity } : item
        ))
        setCart({ ...cart, items: updatedItems })
      } else {
        toast.error("Something went wrong")
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }

  const decreaseQty = async (foodId, quantity) => {
    try {
      const newQuantity = quantity - 1;
      if (newQuantity < 0) {
        toast.error("Something went wrong")
        return;
      }

      const postData = {
        foodId,
        quantity: newQuantity
      }
      const response = await updateItemQuantity(postData, token)

      if (response.status === 200) {
        const updatedItems = cartItems.map(item => (
          item.foodId === foodId ? { ...item, quantity: newQuantity } : item
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

  const handleRemoveItem = async (foodId) => {
    try {
      const response = await removeItem(foodId, token);

      if (response.status === 200) {
        const updatedItems = cartItems.filter(item => item.foodId !== foodId)
        setCart(prev => ({ ...prev, items: updatedItems }))
      } else {
        toast.error("Something went wrong")
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }

  return (
    <div className="container py-5 fade-slide-in">
      <h1 className="mb-5 cart-title">Your Shopping Cart</h1>

      <div className="row">
        <div className="col-lg-8">
          {
            !cartItems.length ?
              <p>Your cart is empty</p> :
              cartItems.map(item => (
                <div className="card mb-4">
                  <div className="card-body">

                    <div className="row cart-item mb-3 align-items-center">
                      <div className="col-md-6">
                        <h5>{item.foodName}</h5>
                        <p className="text-muted">{item.foodCategoryName}</p>
                        <p>{item.foodPrice.toFixed(2)}</p>

                        <div className="input-group mb-2" style={{ maxWidth: "120px" }}>
                          <button onClick={(e) => decreaseQty(item?.foodId, item?.quantity)}
                            className={`btn btn-outline-secondary btn-sm qty-btn ${item.quantity <= 1 && 'for-dustbin-icon'}`}
                          >{item?.quantity > 1 ? '-' : <img src="/dustbin.png" alt="" style={{ maxWidth: '19px' }} />}</button>
                          <input
                            type="text"
                            className="form-control form-control-sm text-center cart-ring"
                            readOnly
                            value={item.quantity}
                          />
                          <button onClick={(e) => increaseQty(item?.foodId, item?.quantity)}
                            className="btn btn-outline-secondary btn-sm qty-btn">+</button>
                        </div>
                      </div>

                      <div className="col-md-4 text-end">
                        <p className="fw-bold">₹{(item.foodPrice * item.quantity).toFixed(2)}</p>
                        <button onClick={() => handleRemoveItem(item.foodId)}
                          className="btn btn-sm btn-outline-danger">
                          <i className="bi bi-trash"></i> Remove
                        </button>
                      </div>

                      <hr />
                    </div>

                  </div>
                </div>
              ))
          }

          <Link to={"/explore"} className="btn btn-outline-primary">
            <i className="bi bi-arrow-left me-2"></i>Continue Shopping
          </Link>
        </div>

        <div className="col-lg-4">
          <div className="card cart-summary">
            <div className="card-body">

              <h5 className="card-title mb-4">Order Summary</h5>

              <div className="d-flex justify-content-between mb-2">
                <span>Subtotal</span><span>₹{subTotal.toFixed(2)}</span>
              </div>

              <div className="d-flex justify-content-between mb-2">
                <span>Shipping</span><span>₹{shippingCharge.toFixed(2)}</span>
              </div>

              <div className="d-flex justify-content-between mb-2">
                <span>Tax</span><span>₹{tax.toFixed(2)}</span>
              </div>

              <hr />

              <div className="d-flex justify-content-between mb-3">
                <strong>Total</strong><strong>₹{total.toFixed(2)}</strong>
              </div>

              <Link to={"/place-order"} className="btn btn-primary w-100">
                Proceed to Checkout
              </Link>

            </div>
          </div>
        </div>

      </div>
    </div>
  )
}