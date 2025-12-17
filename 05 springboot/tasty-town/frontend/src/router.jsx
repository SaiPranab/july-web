import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ExploreFood from "./pages/explore foods/ExploreFood";
import FoodDetails from "./pages/food details/FoodDetails";
import ErrorPage from "./common/ErrorPage";
import Login from "./pages/login/Login";
import CustomerLayout from "./layout/CustomerLayout";
import Home from "./pages/home/Home";

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
        ]
      }
    ]
  }
])

export default router;