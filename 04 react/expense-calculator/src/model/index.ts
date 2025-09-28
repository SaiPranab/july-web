export interface Expense {
  id: string,
  title: string,
  category: string,
  amount: string
}

export interface ExpenseError {
  title: string,
  category: string,
  amount: string
}

export interface MenuPosition {
  left: number, 
  top: number
}