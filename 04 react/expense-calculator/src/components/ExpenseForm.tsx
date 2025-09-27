import { useState, type FormEvent } from "react"
import type { Expense, ExpenseError } from "../model";
import Input from "./Input";
import Select from "./Select";

interface ExpenseFormProps {
  setExpenses: React.Dispatch<React.SetStateAction<Expense[]>>;
}

function ExpenseForm({ setExpenses }: ExpenseFormProps) {
  console.log('rendering')
  const [expense, setExpense] = useState<Expense>({
    id: '',
    title: '',
    category: '',
    amount: ''
  })
  const [errors, setErrors] = useState<ExpenseError>({
    title: '',
    category: '',
    amount: ''
  });

  const validationRules: any = {
    id: [],
    title: [
      { required: true, message: "Title is required" },
      { minLength: 3, message: "Title should be atleast 3 characters long" }
    ],
    category: [
      { required: true, message: "Category is required" }
    ],
    amount: [
      { required: true, message: "Amount is required" },
      { pattern: /^(0|[1-9]\d*)$/, message: "Amount should be positive or zero" }
    ]
  }

  function validate(formData: Expense): ExpenseError {
    const errorData: ExpenseError = {
      title: '',
      category: '',
      amount: ''
    };

    Object.entries(formData).forEach(([key, value]) => validationRules[key].some((rule: any) => {
      if (rule.required && !value) {
        errorData[key as keyof ExpenseError] = rule.message
        return true
      }

      if (rule.minLength && value.length < 3) {
        errorData[key as keyof ExpenseError] = rule.message
        return true
      }

      if (rule.pattern && !rule.pattern.test(value)) {
        errorData[key as keyof ExpenseError] = rule.message
        return true;
      }
    }))

    setErrors(errorData)
    return errorData
  }

  function handleSubmit(e: FormEvent): void {
    e.preventDefault()

    const errorData: ExpenseError = validate(expense)
    if (Object.values(errorData).some(val => val !== '')) return

    const newExpense: Expense = {
      id: crypto.randomUUID(),
      title: expense.title,
      category: expense.category,
      amount: expense.amount
    }

    setExpenses(prevExpenses => ([
      ...prevExpenses, newExpense
    ]))

    setExpense({
      id: '',
      title: '',
      category: '',
      amount: ''
    })
  }

  function handleChange(e: FormEvent): void {
    const { name, value } = (e.target as HTMLFormElement);

    setExpense(prevExpense => ({
      ...prevExpense,
      [name]: value
    }))

    setErrors(prevErros => ({
      ...prevErros,
      [name]: ''
    }))
  }

  return (
    <>
      <form className="expense-form" onSubmit={handleSubmit}>
        <Input
          label="Title"
          id="title"
          name="title"
          value={expense.title}
          onChange={handleChange}
          error={errors.title}
        />
        <Select
          label="Category"
          id="category"
          name="category"
          value={expense.category}
          onChange={handleChange}
          defaultOption="Select Category"
          options={["Grocery", "Clothes", "Bills", "Education", "Medicine"]}
          error={errors.category}
        />
        <Input
          label="Amount"
          id="amount"
          name="amount"
          value={expense.amount}
          onChange={handleChange}
          error={errors.amount}
        />
        <button className="add-btn">Add</button>
      </form>
    </>
  )
}

export default ExpenseForm