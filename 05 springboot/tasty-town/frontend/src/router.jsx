import { createBrowserRouter } from "react-router-dom";
import App from "./App";
import ExploreFood from "./components/customer/explore foods/ExploreFood";

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
      }
    ]
  }
])

export default router;