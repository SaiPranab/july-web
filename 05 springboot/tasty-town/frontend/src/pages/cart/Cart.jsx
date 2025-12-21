import { useContext } from "react"
import "./cart.css"
import { CartContext } from "@/context/CartContext"
import { Link } from "react-router-dom"

export default function Cart() {
  const { cart } = useContext(CartContext)
  console.log("//////////", cart)

  return (
    <div className="container py-5 fade-slide-in">
      <h1 className="mb-5 cart-title">Your Shopping Cart</h1>

      <div className="row">
        <div className="col-lg-8">

          {
            !cart?.items?.length ? 
              <p>Your cart is empty</p>  : 
              cart?.items?.map(item => (
                <div className="card mb-4">
                  <div className="card-body">

                    <div className="row cart-item mb-3 align-items-center">
                      <div className="col-md-6">
                        <h5>{item.foodName}</h5>
                        <p className="text-muted">{ item.foodCategoryName }</p>
                        <p>{ item.foodPrice.toFixed(2) }</p>

                        <div className="input-group mb-2" style={{ maxWidth: "120px"}}>
                          <button className="btn btn-outline-secondary btn-sm qty-btn">-</button>
                          <input
                            type="text"
                            className="form-control form-control-sm text-center cart-ring"
                            readOnly
                            value={item.quantity}
                          />
                          <button className="btn btn-outline-secondary btn-sm qty-btn">+</button>
                        </div>
                      </div>

                      <div className="col-md-4 text-end">
                        <p className="fw-bold">₹{(item.foodPrice * item.quantity).toFixed(2)}</p>
                        <button className="btn btn-sm btn-outline-danger">
                          <i className="bi bi-trash"></i> Remove
                        </button>
                      </div>

                      <hr />
                    </div>

                  </div>
                </div>
              ))
          }

          {/* <!-- Cart List Container --> */}
          {/* <div className="card mb-4">
            <div className="card-body">

              <div className="row cart-item mb-3 align-items-center">
                <div className="col-md-6">
                  <h5>Item Name</h5>
                  <p className="text-muted">Category</p>
                  <p>Price</p>

                  <div className="input-group mb-2" style={{ maxWidth: "120px"}}>
                    <button className="btn btn-outline-secondary btn-sm">-</button>
                    <input
                      type="text"
                      className="form-control form-control-sm text-center"
                      readOnly
                    />
                    <button className="btn btn-outline-secondary btn-sm">+</button>
                  </div>
                </div>

                <div className="col-md-4 text-end">
                  <p className="fw-bold">Total</p>
                  <button className="btn btn-sm btn-outline-danger">
                    <i className="bi bi-trash"></i> Remove
                  </button>
                </div>

                <hr />
              </div>

            </div>
          </div> */}

          <Link to={"/explore"} className="btn btn-outline-primary">
            <i className="bi bi-arrow-left me-2"></i>Continue Shopping
          </Link>
        </div>

        <div className="col-lg-4">
          <div className="card cart-summary">
            <div className="card-body">

              <h5 className="card-title mb-4">Order Summary</h5>

              <div className="d-flex justify-content-between mb-2">
                <span>Subtotal</span><span>₹0.00</span>
              </div>

              <div className="d-flex justify-content-between mb-2">
                <span>Shipping</span><span>₹0.00</span>
              </div>

              <div className="d-flex justify-content-between mb-2">
                <span>Tax</span><span>₹0.00</span>
              </div>

              <hr />

              <div className="d-flex justify-content-between mb-3">
                <strong>Total</strong><strong>₹0.00</strong>
              </div>

              <button className="btn btn-primary w-100">
                Proceed to Checkout
              </button>

            </div>
          </div>
        </div>

      </div>
    </div>
  )
}