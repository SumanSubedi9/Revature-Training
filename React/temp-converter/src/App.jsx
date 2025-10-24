import { useState, createContext } from "react";
import "./App.css";
import CelsiusInput from "./components/Celcius";
import FahrenheitInput from "./components/Fahrenheit";

const TempContext = createContext();

function App() {
  const [celsius, setCelsius] = useState("");
  const [fahrenheit, setFahrenheit] = useState("");

  const handleCelsiusChange = (value) => {
    setCelsius(value);
    setFahrenheit(value === "" ? "" : Number((9 / 5) * value + 32).toFixed(2));
  };

  const handleFahrenheitChange = (value) => {
    setFahrenheit(value);
    setCelsius(value === "" ? "" : Number((value - 32) * (5 / 9)).toFixed(2));
  };

  return (
    <>
      <TempContext.Provider
        value={{
          celsius,
          fahrenheit,
          handleCelsiusChange,
          handleFahrenheitChange,
        }}
      >
        <CelsiusInput />
        <FahrenheitInput />
      </TempContext.Provider>
    </>
  );
}
export { TempContext };
export default App;
