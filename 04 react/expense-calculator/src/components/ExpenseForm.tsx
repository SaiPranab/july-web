import type { FormEvent } from "react"
import type { Expense } from "../model";

interface ExpenseFormProps {
  setExpenses: React.Dispatch<React.SetStateAction<Expense[]>>;
}

function ExpenseForm({ setExpenses }: ExpenseFormProps) {
  function handleSubmit(e: FormEvent): void {
    e.preventDefault()

    const formData: FormData = new FormData(e.target as HTMLFormElement);
    const expense: any = {}
    for (const [key, value] of formData.entries()) {
      // console.log(key, '->', value)
      expense[key] = value;
    }

    setExpenses(expenses => ([...expenses, { ...expense, id: crypto.randomUUID() }]));

    (e.target as HTMLFormElement).reset();
  }

  return (
    <>
      <form className="expense-form" onSubmit={handleSubmit}>
        <div className="input-container">
          <label htmlFor="title">Title</label>
          <input id="title" name="title" />
        </div>
        <div className="input-container">
          <label htmlFor="category">Category</label>
          <select id='category' name='category'>
            <option hidden>Select Category</option>
            <option value="Grocery">Grocery</option>
            <option value="Clothes">Clothes</option>
            <option value="Bills">Bills</option>
            <option value="Education">Education</option>
            <option value="Medicine">Medicine</option>
          </select>
        </div>
        <div className="input-container">
          <label htmlFor="amount">Amount</label>
          <input id="amount" name="amount" />
        </div>
        <button className="add-btn">Add</button>
      </form>
    </>
  )
}

export default ExpenseForm