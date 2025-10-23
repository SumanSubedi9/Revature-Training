const CelsiusInput = ({ value, onChange }) => {
  return (
    <>
      <div className="temp-section">
        <h2>Celsius</h2>
        <input
          type="number"
          value={value}
          onChange={(e) => {
            onChange(e.target.value == "" ? "" : Number(e.target.value));
          }}
          placeholder="Enter Celsius"
        ></input>
      </div>
    </>
  );
};
export default CelsiusInput;
