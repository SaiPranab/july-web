import { fetchFoods } from '@/service/foodService';
import React, { useEffect, useState } from 'react'
import { toast } from 'react-toastify';

const FoodsList = () => {
    const [foods, setFoods] = useState([])

    const loadFoods = async () => {
        try {
            const res = await fetchFoods();
            if (res.status === 200) {
                setFoods(res.data)
            } else {
                toast.error("Something went wrong")
            }
        } catch (error) {
            toast.error("Something went wrong")
        }
    };

    const removeFood = async (foodId) => {
        // try {
        //     const res = await fetchFoods();
        //     if (res.status === 200) {
        //         setFoods(res.data)
        //     } else {
        //         toast.error("Something went wrong")
        //     }
        // } catch (error) {
        //     toast.error("Something went wrong")
        // }

        alert("Food removed")
    };

    useEffect(() => {
        loadFoods()
    }, [])

    return (
        <div class="py-5 row justify-content-center fade-slide-in">
            <div class="col-11 card shadow-lg py-2">

                <table class="table table-hover">
                    <thead>
                        <tr>
                            <th>Image</th>
                            <th>Name</th>
                            <th>Category</th>
                            <th>Price</th>
                            <th>Action</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            foods.map(food => (
                                <tr key={food.foodId}>
                                    <td>
                                        <img src="" alt="food" height="48" width="48" />
                                    </td>

                                    <td>{food.foodName}</td>
                                    <td>{food.categoryName}</td>
                                    <td>₹{food.foodPrice.toFixed(2)}</td>
                                    <td class="text-danger">
                                        <i class="bi bi-trash-fill fs-4"
                                            onClick={() => removeFood(food.foodId)}
                                        ></i>
                                    </td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>

            </div>
        </div>
    )
}

export default FoodsList