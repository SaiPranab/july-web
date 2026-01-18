import { AuthContext } from "@/context/AuthContext";
import { CategoryContext } from "@/context/CategoryContext";
import { deleteCategoryById } from "@/service/categoryService";
import { useContext } from "react";
import { toast } from "react-toastify";

export default function CategoryList() {
    const { categories, setCategories } = useContext(CategoryContext)
    const { token } = useContext(AuthContext)
    
    const removeCategory = async (categoryId) => {
        try {
            const res = await deleteCategoryById(token, categoryId)
            if(res.status === 204) {
                toast.success("Category removed")

                setCategories(prev => prev.filter(category => category.categoryId !== categoryId))
            } else {
                toast.error("Something went wrong")
            }
        } catch (error) {
            toast.error("Something went wrong")
        }
    }

    return (
        <div className="py-5 row ps-5 fade-slide-in">
            <div className="col-6 card shadow-lg">

            <table className="table table-hover align-middle">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Action</th>
                    </tr>
                </thead>

                <tbody>
                    { categories.map(category => (
                        <tr key={category.categoryId}>
                            <td>{category.categoryName}</td>
                            <td className="text-danger">
                                <i className="bi bi-trash-fill fs-4"
                                    onClick={() => removeCategory(category.categoryId)}
                                ></i>
                            </td>
                        </tr>
                    ))}

                </tbody>
            </table>

            </div>
        </div>
    )
}