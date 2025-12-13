import { useContext, useEffect, useState } from "react";
import styles from "./explorefood.module.css";
import { fetchPaginatedFoods } from "@/service/foodService";
import { CategoryContext } from "@/context/CategoryContext";
import Navbar from "@/components/customer/navbar/Navbar";
import FoodDisplay from "../../components/customer/food display/FoodDisplay";

export default function ExploreFood() {
  const [foods, setFoods] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("all");
  const [search, setSearch] = useState("");
  const [currentPage, setCurrentPage] = useState(0);
  const [totalPages, setTotalPages] = useState(0);

  const categories = useContext(CategoryContext);

  const pageSize = 2;

  const fetchFoods = async () => {
    try {
      const fetchedFoods = await fetchPaginatedFoods(currentPage, pageSize, {
        categoryId: selectedCategory,
        search,
      });

      setFoods(fetchedFoods.content);
      setTotalPages(fetchedFoods.totalPages);
    } catch (error) {
      console.log("Error fetching foods");
      setFoods([]);
      setTotalPages(0);
    }
  };

  const handleChange = async (e) => {
    const { name, value } = e.target;

    if (name === "categoryId") {
      setSelectedCategory(value);
      setCurrentPage(0);
    }

    if (name === "search") {
      setSearch(value);
      setCurrentPage(0);
    }
  };

  const handlePageClick = (e) => {
    const { value } = e.target;
    setCurrentPage(value);
  };

  useEffect(() => {
    fetchFoods();
  }, [selectedCategory, search, currentPage]);

  return (
    <>
      {/* Navbar added here */}
      <Navbar />
      <div className={`${styles["page-container"]} container`}>
        <div className={`${styles["content-wrapper"]}`}>
          {/* <!-- Search + Category Filter --> */}
          <div className="row justify-content-center">
            <div className="col-md-6">
              <form>
                <div className="input-group mb-3">
                  <select
                    onChange={handleChange}
                    name="categoryId"
                    className="form-select mt-2"
                    style={{ maxWidth: "150px" }}
                  >
                    <option value="all">All</option>
                    {/* <!-- More categories dynamically inserted --> */}
                    {categories.map((category) => (
                      <option
                        value={category.categoryId}
                        key={category.catgeoryId}
                      >
                        {category.categoryName}
                      </option>
                    ))}
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
              <FoodDisplay foods={foods} />
            </div>
          </div>
        </div>

       {/* pagination */}
        <div className="d-flex justify-content-center mt-5 mb-4">
          <div className={`pagination ${styles.pagination}`}>
            <button
              className="btn btn-sm mx-1 btn-outline-primary"
              disabled={currentPage <= 0}
              onClick={() => setCurrentPage((prev) => prev - 1)}
            >
              Back
            </button>

            {Array.from({ length: totalPages }, (_, idx) => (
              <button
                key={idx}
                className={`btn btn-sm mx-1 ${
                  idx === currentPage
                    ? "btn-primary active"
                    : "btn-outline-primary"
                }`}
                onClick={() => setCurrentPage(idx)}
              >
                {idx + 1} 
              </button>
            ))}

            <button
              className="btn btn-sm mx-1 btn-outline-primary"
              disabled={currentPage >= totalPages-1}
              onClick={() => setCurrentPage((prev) => prev + 1)}
            >
              Next
            </button>
          </div>
        </div>
      </div>
    </>
  );
}
