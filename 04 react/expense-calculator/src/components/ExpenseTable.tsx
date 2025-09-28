import { useState, type Dispatch, type FormEvent, type SetStateAction } from "react"
import type { Expense, MenuPosition } from "../model"
import ContextMenu from "./ContextMenu"

interface ExpenseFormProps {
  expenses: Expense[],
  setExpenses: Dispatch<SetStateAction<Expense[]>>
}

function ExpenseTable({ expenses, setExpenses }: ExpenseFormProps) {
  const [selectedCategory, setSelectedCategory] = useState<string>('')
  const [sortingCallback, setSortingCallback] = useState<(a: Expense, b: Expense) => number>(() => () => 0)
  const [menuPosition, setMenuPosition] = useState<MenuPosition>({ left: -10000, top: -10000 })
  const [rowId, setRowId] = useState<string>('')

  function handleContextMenu(e: any, expenseId: string) {
    e.preventDefault()

    setMenuPosition({
      left: e.clientX + 2,
      top: e.clientY + 2
    })

    setRowId(expenseId)
  }

  const filteredExpenses: Expense[] = expenses.filter(prevExpense =>
    prevExpense.category.toLowerCase().includes(selectedCategory))

  const total = filteredExpenses.reduce((acc, current) => {
    return acc + parseInt(current.amount)
  }, 0)
  return (
    <>
      <ContextMenu menuPosition={menuPosition} rowId={rowId} setExpenses={setExpenses} setMenuPosition={setMenuPosition}/>
      <table className="expense-table" onClick={() => setMenuPosition({ left: -10000, top: -10000 })}>
        <thead>
          <tr>
            <th>Title</th>
            <th>
              <select onChange={(e: FormEvent) => setSelectedCategory((e.target as HTMLSelectElement).value)}>
                <option value="">All</option>
                <option value="grocery">Grocery</option>
                <option value="clothes">Clothes</option>
                <option value="bills">Bills</option>
                <option value="education">Education</option>
                <option value="medicine">Medicine</option>
              </select>
            </th>
            <th className="amount-column">
              <div>
                <span>Amount</span>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="10"
                  viewBox="0 0 384 512"
                  className="arrow up-arrow"
                  // onClick={() => setExpenses([...expenses.sort((a, b) => parseInt(a.amount) - parseInt(b.amount))])}
                  onClick={() => setSortingCallback(() => (a: Expense, b: Expense) => parseInt(a.amount) - parseInt(b.amount))}
                >
                  <title>Ascending</title>
                  <path
                    d="M214.6 41.4c-12.5-12.5-32.8-12.5-45.3 0l-160 160c-12.5 12.5-12.5 32.8 0 45.3s32.8 12.5 45.3 0L160 141.2V448c0 17.7 14.3 32 32 32s32-14.3 32-32V141.2L329.4 246.6c12.5 12.5 32.8 12.5 45.3 0s12.5-32.8 0-45.3l-160-160z"
                  />
                </svg>
                <svg
                  xmlns="http://www.w3.org/2000/svg"
                  width="10"
                  viewBox="0 0 384 512"
                  className="arrow down-arrow"
                  // onClick={() => setExpenses([...expenses.sort((a, b) => parseInt(b.amount) - parseInt(a.amount))])}
                  onClick={() => setSortingCallback(() => (a: Expense, b: Expense) => parseInt(b.amount) - parseInt(a.amount))}
                >
                  <title>Descending</title>
                  <path
                    d="M169.4 470.6c12.5 12.5 32.8 12.5 45.3 0l160-160c12.5-12.5 12.5-32.8 0-45.3s-32.8-12.5-45.3 0L224 370.8 224 64c0-17.7-14.3-32-32-32s-32 14.3-32 32l0 306.7L54.6 265.4c-12.5-12.5-32.8-12.5-45.3 0s-12.5 32.8 0 45.3l160 160z"
                  />
                </svg>
              </div>
            </th>
          </tr>
        </thead>
        <tbody>
          {
            filteredExpenses
              .sort(sortingCallback)
              .map(expense => (
                <tr key={expense.id} onContextMenu={(e: any) => handleContextMenu(e, expense.id)}>
                  <td>{expense.title}</td>
                  <td>{expense.category}</td>
                  <td>₹{expense.amount}</td>
                </tr>
              ))
          }
          {
            filteredExpenses.length === 0 ?
              <tr style={{ textAlign: 'center' }}>
                <i>No expenses found</i>
              </tr> :
              <tr>
                <th>Total</th>
                <th style={{ textAlign: 'center' }}>
                  <button
                    style={{ padding: '5px 30px', fontFamily: 'inherit', fontSize: 'inherit' }}
                    onClick={() => setSortingCallback(() => () => 0)}
                  >
                    Clear
                  </button>
                </th>
                <th>₹{total}</th>
              </tr>
          }
        </tbody>
      </table>
    </>
  )
}

export default ExpenseTable