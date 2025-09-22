function ExpenseForm() {
  return (
    <>
      <form className="expense-form">
        <div className="input-container">
          <label htmlFor="title">Title</label>
          <input id="title" />
        </div>
        <div className="input-container">
          <label htmlFor="category">Category</label>
          <select id='category' name='category'>
            <option hidden>Select Category</option>
            <option value="grocery">Grocery</option>
            <option value="clothes">Clothes</option>
            <option value="bills">Bills</option>
            <option value="education">Education</option>
            <option value="medicine">Medicine</option>
          </select>
        </div>
        <div className="input-container">
          <label htmlFor="amount">Amount</label>
          <input id="amount" />
        </div>
        <button className="add-btn">Add</button>
      </form>
    </>
  )
}

export default ExpenseForm