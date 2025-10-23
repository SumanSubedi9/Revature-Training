const FahrenheitInput = ({ value, onChange }) => {
  return (
    <>
      <div className="temp-section">
        <h2>Fahrenheit</h2>
        <input
          type="number"
          value={value}
          onChange={(e) => {
            onChange(e.target.value == "" ? "" : Number(e.target.value));
          }}
          placeholder="Enter Fahrenheit"
        ></input>
      </div>
    </>
  );
};
export default FahrenheitInput;
