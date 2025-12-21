export const calculateCartTotals = (cartItems) => {
  const subTotal = cartItems.reduce((acc, item) => {
    return acc + (item.foodPrice * item.quantity)
  }, 0)

  const shippingCharge = subTotal === 0 ? 0 : 10
  const tax = subTotal * 0.1
  const total = subTotal + shippingCharge + tax

  return { subTotal, shippingCharge, tax, total}
}