import Navbar from "@/components/customer/navbar/Navbar"
import { Outlet } from "react-router-dom"

const CustomerLayout = () => {
  return (
    <>
      <Navbar />
      <Outlet />
    </>
  )
}

export default CustomerLayout