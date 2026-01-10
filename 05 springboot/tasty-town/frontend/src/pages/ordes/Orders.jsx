import { AuthContext } from "@/context/AuthContext"
import { fetchOrders } from "@/service/orderService"
import { useCallback, useContext, useEffect, useState } from "react"
import { toast } from "react-toastify"

export default function Orders() {
  const { token } = useContext(AuthContext)
  const [orders, setOrders] = useState([])

  const fetchOrdersOfAnUser = async () => {
    try {
      const response = await fetchOrders(token)
      if (response.status === 200) {
        setOrders(response.data)
      }
    } catch (err) {
      toast.error("Something went wrong")
    }
  }

  useEffect(() => {
    fetchOrdersOfAnUser()
  }, [])

  const statusLabels = {
    "FOOD_PREPARING": "FOOD PREPARING",
    "OUT_FOR_DELIVERY": "OUT FOR DELIVERY",
    "DELIVERED": "DELIVERED",
  }

  const statusImages = {
    "FOOD_PREPARING": "food preparing.png",
    "OUT_FOR_DELIVERY": "out for delivery.png",
    "DELIVERED": "delivered.png",
  }

  return (
    <div className="container fade-slide-in">
      <div className="py-5 row justify-content-center">
        <div className="col-11 card shadow-lg">
          <h3 className="p-3">Orders</h3>

          {/* hanlde if no orers found*/}
          {
            !orders.length ? (
              <p className="text-center">No orders found.</p>
            ) : (
              <table className="table table-responsive table-hover">
                <tbody>
                  {/* Sample orders row -> Map Tabble here */}
                  {
                    orders.map(order => (
                      <tr key={order.orderId}>
                        <td>
                          {/* Show Image according to status */}
                          <img src={statusImages[order.orderStatus]} alt={statusLabels[order.orderStatus]} height={48} width={48} />
                        </td>
                        <td>
                          {order.orderItems.map((orderItem, idx) => (
                            <span>{`${orderItem.foodName} x ${orderItem.quantity} ${idx !== (order.orderItems.length - 1) ? "," : ""} `}</span>
                          ))}
                        </td>
                        <td>₹{order.totalAmount}</td>
                        <td>Items: {order.orderItems.length}</td>
                        <td className="fw-bold text-capitalize " style={{ color: '#ff8800' }}>
                          {statusLabels[order.orderStatus]}
                        </td>
                      </tr>
                    ))
                  }
                </tbody>
              </table>
            )
          }


        </div>
      </div>
    </div>
  )
}