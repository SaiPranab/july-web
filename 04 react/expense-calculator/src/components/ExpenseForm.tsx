import { useEffect, useRef, useState, type FormEvent } from "react"
import type { Expense } from "../model";

interface ExpenseFormProps {
  setExpenses: React.Dispatch<React.SetStateAction<Expense[]>>;
}

function ExpenseForm({ setExpenses }: ExpenseFormProps) {
  console.log('rendering')
  // const [expense, setExpense] = useState<Expense>({
  //   id: '',
  //   title: '',
  //   category: '',
  //   amount: ''
  // })

  // const myRef = useRef(null);

  // useEffect(() => {
  //   // console.log("useEffect")
  //   console.log(myRef)
  //   myRef.current.style.backgroundColor = 'red'
  // })
  // console.log("Hii")

  const titleRef = useRef<HTMLInputElement>(null!);
  const categoryRef = useRef<HTMLSelectElement>(null!)
  const amountRef = useRef<HTMLInputElement>(null!)

  function handleSubmit(e: FormEvent): void {
    e.preventDefault()
    const newExpense: Expense = {
      id: crypto.randomUUID(),
      title: titleRef.current.value,
      category: categoryRef.current.value,
      amount: amountRef.current.value
    }
    setExpenses(prevExpenses => ([
      ...prevExpenses, newExpense
    ]))
    titleRef.current.value = ""
    categoryRef.current.value = ""
    amountRef.current.value = ""
  }

  // function handleSubmit(e: FormEvent): void {
  //   e.preventDefault()

  //   const newExpense: Expense = {
  //     id: crypto.randomUUID(),
  //     title: expense.title,
  //     category: expense.category,
  //     amount: expense.amount
  //   }

  //   setExpenses(prevExpenses => ([
  //     ...prevExpenses, newExpense
  //   ]))

  //   setExpense({
  //     id: '',
  //     title: '',
  //     category: '',
  //     amount: ''
  //   })
  // }

  // return (
  //   <>
  //     {/* <button onClick={() => {
  //       // myRef.current++
  //       console.log('myReffffffff', myRef.current)
  //     }}>Click Me!!!!</button>
  //     <h1 style={{ textAlign: 'center' }} ref={myRef} >lalala</h1> */}

  //     <form className="expense-form" onSubmit={handleSubmit}>
  //       <div className="input-container">
  //         <label htmlFor="title">Title</label>
  //         <input id="title" name="title" value={expense.title}
  //           onChange={(e: any) => setExpense((prev) => ({ ...prev, title: e.target.value }))} />
  //       </div>
  //       <div className="input-container">
  //         <label htmlFor="category">Category</label>
  //         <select id='category' name='category' value={expense.category}
  //           onChange={(e: any) => setExpense((prev) => ({ ...prev, category: e.target.value }))}>
  //           <option hidden>Select Category</option>
  //           <option value="Grocery">Grocery</option>
  //           <option value="Clothes">Clothes</option>
  //           <option value="Bills">Bills</option>
  //           <option value="Education">Education</option>
  //           <option value="Medicine">Medicine</option>
  //         </select>
  //       </div>
  //       <div className="input-container">
  //         <label htmlFor="amount">Amount</label>
  //         <input id="amount" name="amount" value={expense.amount}
  //           onChange={(e: any) => setExpense((prev) => ({ ...prev, amount: e.target.value }))} />
  //       </div>
  //       <button className="add-btn">Add</button>
  //     </form>
  //   </>
  // )

  return (
    <>
      <form className="expense-form" onSubmit={handleSubmit}>
        <div className="input-container">
          <label htmlFor="title">Title</label>
          <input id="title" name="title" ref={titleRef} />
        </div>
        <div className="input-container">
          <label htmlFor="category">Category</label>
          <select id='category' name='category' ref={categoryRef} >
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
          <input id="amount" name="amount" ref={amountRef} />
        </div>
        <button className="add-btn">Add</button>
      </form>
    </>
  )
}

export default ExpenseForm