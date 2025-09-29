import type { Dispatch, SetStateAction } from "react"
import type { Expense, MenuPosition } from "../model"

interface ContextMenuProps {
  menuPosition: MenuPosition,
  rowId: string,
  expenses: Expense[]
  setExpenses: Dispatch<SetStateAction<Expense[]>>,
  setMenuPosition: Dispatch<SetStateAction<MenuPosition>>
  setExpense: Dispatch<SetStateAction<Expense>>
  setEditingRowId: Dispatch<SetStateAction<string>>
}

function ContextMenu({ menuPosition, rowId, expenses, setExpenses, setMenuPosition, setExpense, setEditingRowId }: ContextMenuProps) {
  return (
    <>
      <div className="context-menu" style={menuPosition}>
        <div
          onClick={() => {
            const existingExpense = expenses.find(expense => expense.id === rowId)
            if (existingExpense) {
              const { id, title, category, amount } = existingExpense
              setExpense({
                id,
                title,
                category,
                amount
              })
              setEditingRowId(rowId)
            }
            setMenuPosition({ left: -10000, top: -10000 })
          }}
        >
          Edit
        </div>
        <div
          onClick={() => {
            setExpenses(prevExpenses => prevExpenses.filter(expense => expense.id !== rowId))
            setMenuPosition({ left: -10000, top: -10000 })
          }}
        >
          Delete
        </div>
      </div>
    </>
  )
}

export default ContextMenu