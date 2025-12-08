import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ExploreFood from "./pages/explore foods/ExploreFood";
import FoodDetails from "./pages/food details/FoodDetails";

const router = createBrowserRouter([
  {
    path: "/",
    errorElement: <h1>Error Page Works</h1>,
    children: [
      {
        index: true,
        element: <App />
      },
      {
        path: "explore",
        element: <ExploreFood />
      },
      {
        path: "food/:foodId",
        element: <FoodDetails />
      }
    ]
  }
])

export default router;