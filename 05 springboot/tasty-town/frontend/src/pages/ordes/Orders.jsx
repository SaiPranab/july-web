import { AuthContext } from "@/context/AuthContext"
import { fetchOrders } from "@/service/orderService"
import { useCallback, useContext, useState } from "react"

export default function Orders() {
  const { token } = useContext(AuthContext)
  const [order, setOrders] = useState([])

  const fetchOrdersOfAnUser = async () => {
    try {
      const response = await fetchOrders(token)
      if(response.status === 200) {
        setOrders(response)
      }
    } catch(err) {

    }
  }
  return (
    <div className="container fade-slide-in">
      <div className="py-5 row justify-content-center">
        <div className="col-11 card shadow-lg">
          <h3 className="p-3">My Orders</h3>

          {/* hanlde if no orers found*/}
          <p className="text-center">No orders found.</p>

          {/* Orders table */}
          <table className="table table-responsive table-hover">
            <tbody>
              {/* Sample order row -> Map Tabble here */}
              <tr>
                <td>
                  {/* Show Image according to status */}
                  <img src="/default_status.png" alt="Delivery" height={48} width={48} />
                </td>
                <td>
                  {/* Map the order items in format (name x quantity) with comma separated
                  Food Name 1 x 2, Food Name 2 x 1 */}
                </td>
                <td>₹0.00</td>
                <td>Items: 2</td>
                <td className="fw-bold text-capitalize">
                  &#x25cf; Status Here
                </td>
              </tr>
            </tbody>
          </table>
        </div>
      </div>
    </div>
  )
}