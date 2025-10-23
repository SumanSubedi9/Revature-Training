import { useState } from "react";
import "./App.css";
import CelsiusInput from "./components/Celcius";
import FahrenheitInput from "./components/Fahrenheit";

function App() {
  const [celsius, setCelsius] = useState("");
  const [fahrenheit, setFahrenheit] = useState("");

  const handleCelsiusChange = (value) => {
    setCelsius(value);
    setFahrenheit(value == "" ? "" : Number((9 / 5) * value + 32).toFixed(2));
  };

  const handleFahrenheitChange = (value) => {
    setFahrenheit(value);
    setCelsius(value == "" ? "" : Number((value - 32) * (5 / 9)).toFixed(2));
  };

  return (
    <>
      <CelsiusInput value={celsius} onChange={handleCelsiusChange} />
      <FahrenheitInput value={fahrenheit} onChange={handleFahrenheitChange} />
    </>
  );
}

export default App;
