import { useContext, useState } from "react"
import styles from "./explorefood.module.css"
import { fetchPaginatedFoods } from "@/service/foodService"
import { CategoryContext } from "@/context/CategoryContext"

export default function ExploreFood() {
  const [foods, setFoods] = useState([])
  const [selectedCategory, setSelectedCategory] = useState('all')
  const [search, setSearch] = useState('')
  const [currentPage, setCurrentPage] = useState(0)
  const [totalPages, setTotalPages] = useState(0)

  const categories = useContext(CategoryContext)

  const pageSize = 12;

  const fetchFoods = async () => {
    try {
      const fetchedFoods = await fetchPaginatedFoods(currentPage, pageSize, {
        categoryId: selectedCategory,
        search
      })
    } catch (error) {
      console.log("Error fetching foods")
    }
  }

  const handleChange = async (e) => {
    console.log(e)
  }

  return (
    <div className={`${styles["page-container"]} container`}>
      <div className={`${styles["content-wrapper"]}`}>

        {/* <!-- Search + Category Filter --> */}
        <div className="row justify-content-center">
          <div className="col-md-6">
            <form>
              <div className="input-group mb-3">

                <select onChange={handleChange} name="categoryId" className="form-select mt-2" style={{ maxWidth: "150px" }}>
                  <option value="all">All</option>
                  {/* <!-- More categories dynamically inserted --> */}
                  {
                    categories.map(category =>
                      <option
                        value={category.categoryId}
                        key={category.catgeoryId}
                      >{category.categoryName}</option>
                    )
                  }
                </select>

                <input
                  name="search"
                  value={search}
                  onChange={handleChange}
                  type="text"
                  className="form-control mt-2"
                  placeholder="Search your favorite dish..."
                />

                <button className="btn btn-primary mt-2" type="submit">
                  <i className="bi bi-search"></i>
                </button>

              </div>
            </form>
          </div>
        </div>

        {/* <!-- Food Display Section --> */}
        <div className="fade-slide-in">
          <div className="food-display">
            {/* <!-- Food items dynamically inserted --> */}
            <p>Food items will appear here...</p>
          </div>
        </div>

      </div>

      {/* <!-- Pagination --> */}
      <div className="d-flex justify-content-center mt-5 mb-4">
        <div className="pagination">
          {/* <!-- Example buttons --> */}
          <button className="btn btn-sm mx-1 btn-primary">1</button>
          <button className="btn btn-sm mx-1 btn-outline-primary">2</button>
          <button className="btn btn-sm mx-1 btn-outline-primary">3</button>
        </div>
      </div>

    </div>
  )
}