import type { ChangeEventHandler } from "react"

interface SelectProps { 
  label: string, 
  id: string, 
  name: string, 
  value: string, 
  onChange: ChangeEventHandler<HTMLSelectElement>, 
  defaultOption: string, 
  options: string[], 
  error: string 
}

function Select({ label, id, name, value, onChange, defaultOption, options, error }: SelectProps) {
  return (
    <div className="input-container">
      <label htmlFor={id}>{label}</label>
      <select id={id} name={name} value={value}
        onChange={onChange}>
        <option hidden>{defaultOption}</option>
        {
          options.map((opt, idx) => (
            <option value={opt} key={idx}>{opt}</option>
          ))
        }
      </select>
      <p className="error">{error}</p>
    </div>
  )
}

export default Select