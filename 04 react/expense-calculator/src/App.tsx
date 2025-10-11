import { useState } from 'react'
import './App.css'
import ExpenseForm from './components/ExpenseForm'
import ExpenseTable from './components/ExpenseTable'
import type { Expense } from './model'
import expenseData from './expenseData'

function App() {
  const [expenses, setExpenses] = useState<Expense[]>(expenseData);
  const [expense, setExpense] = useState<Expense>({
    id: '',
    title: '',
    category: '',
    amount: ''
  })
  const[editingRowId, setEditingRowId] = useState<string>('')

  return (
    <>
      <main>
        <h1>Track Your Expense</h1>
        <div className="expense-tracker">
          <ExpenseForm setExpenses={setExpenses} expense={expense} setExpense={setExpense} editingRowId={editingRowId} setEditingRowId={setEditingRowId}/>
          <ExpenseTable expenses={expenses} setExpenses={setExpenses} setExpense={setExpense} setEditingRowId={setEditingRowId}/>
        </div>
      </main>
    </>
  )
}

export default App
