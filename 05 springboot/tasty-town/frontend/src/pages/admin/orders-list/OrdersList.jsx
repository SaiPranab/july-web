import { AuthContext } from "@/context/AuthContext"
import { fetchAllRecentOrders, updateOrderStatus } from "@/service/orderService"
import { useContext, useEffect, useState } from "react"
import { toast } from "react-toastify"

export default function OrdersList() {
  const { token } = useContext(AuthContext)
  const [orders, setOrders] = useState([])

  const fetchAllOrders = async () => {
    try {
      const response = await fetchAllRecentOrders(token)
      if (response.status === 200) {
        setOrders(response.data)
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }

  const updateStatus = async (e, orderId) => {
    try {
      const newStatus = e.target.value
      const response = await updateOrderStatus(token, orderId, newStatus)

      if (response.status === 200) {
        setOrders(prevOrders => prevOrders.map(order => (
          order?.orderId === orderId ? { ...order, orderStatus: newStatus } : order
        )))

        toast.success("Order Status Updated")
      }
    } catch (error) {
      toast.error("Something went wrong")
    }
  }
  console.log(orders)

  useEffect(() => {
    fetchAllOrders()
  }, [token])

  const statusLabels = {
    "FOOD_PREPARING": "FOOD PREPARING",
    "OUT_FOR_DELIVERY": "OUT FOR DELIVERY",
    "DELIVERED": "DELIVERED",
  }

  const statusTransitions = {
    "FOOD_PREPARING": ["OUT_FOR_DELIVERY", "DELIVERED"],
    "OUT_FOR_DELIVERY": ["DELIVERED"],
    "DELIVERED": []
  }

  return (
    <div className="container fade-slide-in">
      <div className="py-2 row justify-content-center">
        <div className="col-11 card shadow-lg py-2">
          {!orders.length ? (
            <p className="text-center">No orders found.</p>
          ) : (
            <table className="table table-responsive table-hover">
              <tbody>
                {
                  orders?.map(order => {
                    return <tr key={order.orderId}>
                      <td>
                        <div>
                          <strong>Items: </strong>
                          {
                            order.orderItems.map((item, idx) => (
                              <span key={idx}>{item.foodName} x {item.quantity}, </span>
                            ))
                          }
                        </div>

                        {/* <!-- Contact & Address --> */}
                        <div className="text-muted mt-1" style={{ fontSize: '0.85rem' }}>
                          <div>
                            <strong>Contact: </strong>
                            {order.contactInfo ? order.contactInfo : 'N/A'}
                          </div>
                          <div>
                            <strong>Address: </strong>
                            {order.addressInfo ? order.addressInfo : 'N/A'}
                          </div>
                        </div>
                      </td>

                      <td>₹ {order.totalAmount.toFixed(2)}</td>
                      <td>Items: {order.orderItems.length} </td>

                      <td className="fw-bold text-capitalize " style={{ color: '#ff8800' }}>
                        <select
                          className="form-control"
                          value={order.orderStatus}
                          onChange={(e) => updateStatus(e, order.orderId)}
                          disabled={!statusTransitions[order.orderStatus].length}
                        >
                          <option value={order.orderStatus}>{statusLabels[order.orderStatus]}</option>
                          {
                            statusTransitions[order.orderStatus].map(nextStatus => (
                              <option key={nextStatus} value={nextStatus}>{statusLabels[nextStatus]}</option>
                            ))
                          }
                        </select>
                      </td>
                    </tr>
                  })
                }
              </tbody>
            </table>
          )}
        </div>
      </div>
    </div>
  )
}