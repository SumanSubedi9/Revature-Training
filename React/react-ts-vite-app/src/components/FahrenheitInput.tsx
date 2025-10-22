interface Props {
  value: number | "";
  onChange: (value: number | "") => void;
}

const FahrenheitInput = ({ value, onChange }: Props) => (
  <div className="temp-section">
    <h2>Fahrenheit</h2>
    <input
      type="number"
      value={value}
      onChange={(e) =>
        onChange(e.target.value === "" ? "" : Number(e.target.value))
      }
      placeholder="Enter °F"
    />
  </div>
);

export default FahrenheitInput;
