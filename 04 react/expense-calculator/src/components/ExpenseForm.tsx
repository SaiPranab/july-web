import { useState, type FormEvent } from "react"
import type { Expense } from "../model";

interface ExpenseFormProps {
  setExpenses: React.Dispatch<React.SetStateAction<Expense[]>>;
}

function ExpenseForm({ setExpenses }: ExpenseFormProps) {
  // const [title, setTitle] = useState<string>('');
  // const [category, setCategory] = useState<string>('')
  // const [amount, setAmount] = useState<string>('')

  // function handleSubmit(e: FormEvent): void {
  //   e.preventDefault()

  //   const expense: Expense = {
  //     id: crypto.randomUUID(),
  //     title,
  //     category,
  //     amount
  //   }

  //   setExpenses(expenses => ([...expenses, expense]));

  //   setTitle('')
  //   setCategory('')
  //   setAmount('')
  // }

  const [expense, setExpense] = useState<Expense>({
    id: '',
    title: '',
    category: '',
    amount: ''
  })

  function handleSubmit(e: FormEvent): void {
    e.preventDefault()

    const newExpense:Expense = {
      id: crypto.randomUUID(),
      title: expense.title,
      category: expense.category,
      amount: expense.amount
    }

    setExpenses(prevExpenses => ([
      ...prevExpenses, newExpense
    ]))

    // for resetting form
    setExpense({
      id: '',
      title: '',
      category: '',
      amount: ''
    })
  }

  return (
    <>
      <form className="expense-form" onSubmit={handleSubmit}>
        <div className="input-container">
          <label htmlFor="title">Title</label>
          <input id="title" name="title" value={expense.title} 
                  onChange={(e: any) => setExpense((prev) => ({...prev, title: e.target.value}))}/>
        </div>
        <div className="input-container">
          <label htmlFor="category">Category</label>
          <select id='category' name='category' value={expense.category} 
                  onChange={(e: any) => setExpense((prev) => ({...prev, category: e.target.value}))}>
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
          <input id="amount" name="amount" value={expense.amount} 
                  onChange={(e: any) => setExpense((prev) => ({...prev, amount: e.target.value}))}/>
        </div>
        <button className="add-btn">Add</button>
      </form>
    </>
  )
}

export default ExpenseForm