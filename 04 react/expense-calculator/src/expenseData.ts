import type { Expense } from "./model"

const expenses: Expense[] = [
  {
    id: crypto.randomUUID(),
    title: 'Milk',
    category: 'Grocery',
    amount: "40"
  },
  {
    id: crypto.randomUUID(),
    title: 'Shirt',
    category: 'Clothes',
    amount: "600"
  },
  {
    id: crypto.randomUUID(),
    title: 'Vegetables',
    category: 'Grocery',
    amount: "100"
  },
  {
    id: crypto.randomUUID(),
    title: 'Electricity Bill',
    category: 'Bills',
    amount: "1100"
  },
]

export default expenses