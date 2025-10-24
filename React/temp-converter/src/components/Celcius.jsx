import { useContext } from "react";
import { TempContext } from "../App";

const CelsiusInput = () => {
  const { celsius, handleCelsiusChange } = useContext(TempContext);

  return (
    <>
      <div className="temp-section">
        <h2>Celsius</h2>
        <input
          type="number"
          value={celsius}
          onChange={(e) => {
            handleCelsiusChange(
              e.target.value === "" ? "" : Number(e.target.value)
            );
          }}
          placeholder="Enter Celsius"
        ></input>
      </div>
    </>
  );
};
export default CelsiusInput;
