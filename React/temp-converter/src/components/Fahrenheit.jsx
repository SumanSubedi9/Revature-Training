import { useContext } from "react";
import { TempContext } from "../App";

const FahrenheitInput = () => {
  const { fahrenheit, handleFahrenheitChange } = useContext(TempContext);
  return (
    <>
      <div className="temp-section">
        <h2>Fahrenheit</h2>
        <input
          type="number"
          value={fahrenheit}
          onChange={(e) => {
            handleFahrenheitChange(
              e.target.value === "" ? "" : Number(e.target.value)
            );
          }}
          placeholder="Enter Fahrenheit"
        ></input>
      </div>
    </>
  );
};
export default FahrenheitInput;
