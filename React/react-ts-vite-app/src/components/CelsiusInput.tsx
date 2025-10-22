interface Props {
  value: number | "";
  onChange: (value: number | "") => void;
}

const CelsiusInput = ({ value, onChange }: Props) => (
  <div className="temp-section">
    <h2>Celsius</h2>
    <input
      type="number"
      value={value}
      onChange={(e) =>
        onChange(e.target.value === "" ? "" : Number(e.target.value))
      }
      placeholder="Enter °C"
    />
  </div>
);

export default CelsiusInput;
