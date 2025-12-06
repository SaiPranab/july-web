import FoodItem from "../food item/FoodItem"

export default ({ foods }) => {
  return (
    <div className="container">
      <div className="row">
        {foods.length > 0 ? (
          foods.map(food => <FoodItem food={food} key={food.foodId} />)
        ) : (
          <div className="text-center">
            <h4>No food available</h4>
          </div>
        )
        }
      </div>
    </div>
  )
}