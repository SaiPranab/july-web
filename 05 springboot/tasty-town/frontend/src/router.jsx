import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ExploreFood from "./pages/explore foods/ExploreFood";
import FoodDetails from "./pages/food details/FoodDetails";
import ErrorPage from "./common/ErrorPage";
import Login from "./pages/auth/Login";
import CustomerLayout from "./layout/CustomerLayout";
import Home from "./pages/home/Home";
import Register from "./pages/auth/Register";
import Cart from "./pages/cart/Cart";
import PlaceOrder from "./pages/place order/PlaceOrder";

const router = createBrowserRouter([
  {
    path: "/",
    errorElement: <ErrorPage />,
    children: [
      {
        element: <CustomerLayout />,
        children: [
          { index: true, element: <Home /> },
          { path: "explore", element: <ExploreFood /> },
          { path: "food/:foodId", element: <FoodDetails /> },
          { path: "login", element: <Login /> },
          { path: "register", element: <Register /> },
          { path: "cart", Component: Cart },
          { path: "place-order", Component: PlaceOrder}
        ]
      }
    ]
  }
])

export default router;