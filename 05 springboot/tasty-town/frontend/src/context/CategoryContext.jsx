import { fetchCategories } from "@/service/categoryService";
import { createContext, useEffect, useState } from "react";

export const CategoryContext = createContext(null)

const CategoryProvider = ({ children }) => {
  const [categories, setCategories] = useState([])

  const getCategories = async () => {
    try {
      const fetchedCategories = await fetchCategories();
      setCategories(fetchedCategories)
    } catch (err) {
      console.log("Error fetching categories", err)
      setCategories([])
    }
  }

  useEffect(() => {
    getCategories()
  }, [])
  
  return (
    <CategoryContext.Provider value={categories}>
      {children}
    </CategoryContext.Provider>
  )
}

export default CategoryProvider;