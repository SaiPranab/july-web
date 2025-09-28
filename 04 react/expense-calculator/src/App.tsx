import { useState } from 'react'
import './App.css'
import ExpenseForm from './components/ExpenseForm'
import ExpenseTable from './components/ExpenseTable'
import type { Expense } from './model'
import expenseData from './expenseData'

function App() {
  const [expenses, setExpenses] = useState<Expense[]>(expenseData);

  return (
    <>
      <main>
        <h1>Track Your Expense</h1>
        <div className="expense-tracker">
          <ExpenseForm setExpenses={setExpenses}/>
          <ExpenseTable expenses={expenses} setExpenses={setExpenses}/>
        </div>
      </main>
    </>
  )
}

export default App
