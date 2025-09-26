import type { ChangeEventHandler } from "react"

interface InputProps {
  label: string,
  id: string,
  name: string,
  value: string,
  onChange: ChangeEventHandler<HTMLInputElement>,
  error: string
}

const Input = ({ label, id, name, value, onChange, error }: InputProps) => {
  return (
    <>
      <div className="input-container">
        <label htmlFor={id}>{label}</label>
        <input id={id} name={name} value={value}
          onChange={onChange} />
        <p className="error">{error}</p>
      </div>
    </>
  )
}

export default Input