import { Link, NavLink } from "react-router-dom";

export default function Sidebar() {
    return (
        <div className="border-end bg-white shadow-lg" id="sidebar-wrapper">
            <div className="sidebar-heading border-bottom bg-light">
                <header className="text-center py-3 fw-bold">
                    Tasty Town
                </header>
            </div>

            <div className="list-group list-group-flush">
                <NavLink to={"/admin/orders"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-cart me-2"></i> Orders
                </NavLink>

                <Link to={"/admin/add-food"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-plus-circle me-2"></i> Add Food
                </Link>

                <Link to={"/admin/add-category"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-plus-circle me-2"></i> Add Category
                </Link>

                <Link to={"/admin/list-food"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-list-ul me-2"></i> List Food
                </Link>

                <Link to={"/admin/list-category"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-list-ul me-2"></i> List Category
                </Link>

                <Link to={"/"} className="list-group-item list-group-item-action list-group-item-light p-3">
                    <i className="bi bi-box-arrow-right me-2"></i> Exit
                </Link>
            </div>
        </div>
    )
}