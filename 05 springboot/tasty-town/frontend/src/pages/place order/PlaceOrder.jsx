import { AuthContext } from "@/context/AuthContext"
import { CartContext } from "@/context/CartContext"
import { placeOrder } from "@/service/orderService"
import { calculateCartTotals } from "@/utils/cartUtils"
import { useContext, useState } from "react"
import { useNavigate } from "react-router-dom"
import { toast } from "react-toastify"

export default function PlaceOrder() {
  const navigate = useNavigate()
  const { token } = useContext(AuthContext)

  const { cart, setCart } = useContext(CartContext)
  const cartItems = cart?.items || []
  const { subTotal, shippingCharge, tax, total } = calculateCartTotals(cartItems)

  const [data, setData] = useState({
    fullName: "",
    email: "",
    phone: "",
    address: "",
    state: "",
    city: "",
    zip: ""
  })

  const handleChange = (e) => {
    e.preventDefault();

    const { name, value } = e.target;
    setData(prev => ({ ...prev, [name]: value }))
  }

  const handlePlaceOrder = async (e) => {
    e.preventDefault();

    try {
      const response = await placeOrder(data, token);

      if (response.status === 201) {
        toast.success('Order placed successfully')
        setCart([])
        navigate("/orders")
      } else {
        toast.error('Something went wrong')
      }
    } catch (err) {
      toast.error('Something went wrong')
    }
  }

  return (
    <main className="container mt-4 fade-slide-in">
      <div className="row g-5">

        {/* Cart Summary */}
        <div className="col-md-5 col-lg-4 order-md-last">
          <h4 className="d-flex justify-content-between align-items-center mb-3">
            <span className="text-primary">Your cart</span>
            <span className="badge bg-primary rounded-pill">{cartItems.length}</span>
          </h4>
          <ul className="list-group mb-3">
            {/* Show Cart Items dynamically here in the below format */}
            {cartItems.length &&
              cartItems.map(item => (
                <li className="list-group-item d-flex justify-content-between lh-sm">
                  <div>
                    <h6 className="my-0">{item.foodName}</h6>
                    <small className="text-muted">Qty: {item.quantity}</small>
                  </div>
                  <span className="text-muted">₹{item.foodPrice * item.quantity}</span>
                </li>
              ))
            }

            {/* Totals */}
            <li className="list-group-item d-flex justify-content-between">
              <span>Shipping</span>
              <span>₹{shippingCharge}</span>
            </li>
            <li className="list-group-item d-flex justify-content-between">
              <span>Tax</span>
              <span>₹{tax}</span>
            </li>
            <li className="list-group-item d-flex justify-content-between">
              <strong>Total</strong>
              <strong>₹{total}</strong>
            </li>
          </ul>
        </div>

        {/* Billing Address Form */}
        <div className="col-md-7 col-lg-8">
          <h4 className="mb-3">Billing address</h4>
          <form onSubmit={handlePlaceOrder}>
            <div className="row g-3">
              <div className="col-12">
                <label className="form-label">Full name</label>
                <input value={data.fullName} onChange={handleChange} name="fullName"
                  type="text" className="form-control" placeholder="John Doe" required/>
              </div>
              <div className="col-sm-6">
                <label className="form-label">Email</label>
                <input value={data.email} onChange={handleChange} name="email"
                  type="email" className="form-control" placeholder="example@email.com" required />
              </div>
              <div className="col-sm-6">
                <label className="form-label">Phone</label>
                <input value={data.phone} onChange={handleChange} name="phone"
                  type="text" className="form-control" placeholder="+91" required />
              </div>
              <div className="col-12">
                <label className="form-label">Address</label>
                <textarea value={data.address} onChange={handleChange} name="address"
                  className="form-control" placeholder="123 Main St" required></textarea>
              </div>
              <div className="col-md-5">
                <label className="form-label">State</label>
                <input value={data.state} onChange={handleChange} name="state"
                  type="text" className="form-control" placeholder="State" required />
              </div>
              <div className="col-md-4">
                <label className="form-label">City</label>
                <input value={data.city} onChange={handleChange} name="city"
                  type="text" className="form-control" placeholder="City" required />
              </div>
              <div className="col-md-3">
                <label className="form-label">Zip</label>
                <input value={data.zip} onChange={handleChange} name="zip"
                  type="text" className="form-control" placeholder="123456" required />
              </div>
            </div>

            {/* <hr className="my-4" /> */}

            <button className="mt-4 w-100 btn btn-primary btn-lg" type="submit">
              Place Order
            </button>
          </form>
        </div>

      </div>
    </main>
  )
}