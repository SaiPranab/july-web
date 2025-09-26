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

// export interface ValidationsRules {
//   title: [{}],
//   category: [{}],
//   amount: []
// }