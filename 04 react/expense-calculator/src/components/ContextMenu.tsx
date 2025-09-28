import type { Dispatch, SetStateAction } from "react"
import type { Expense, MenuPosition } from "../model"

interface ContextMenuProps {
  menuPosition: MenuPosition,
  rowId: string,
  setExpenses: Dispatch<SetStateAction<Expense[]>>,
  setMenuPosition: Dispatch<SetStateAction<MenuPosition>>
}

function ContextMenu({ menuPosition, rowId, setExpenses, setMenuPosition }: ContextMenuProps) {
  return (
    <>
      <div className="context-menu" style={menuPosition}>
        <div>Edit</div>
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