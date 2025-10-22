import { useState } from "react";
import CelsiusInput from "./components/CelsiusInput";
import FahrenheitInput from "./components/FahrenheitInput";
import "./App.css";

const App = () => {
  const [celsius, setCelsius] = useState<number | "">("");
  const [fahrenheit, setFahrenheit] = useState<number | "">("");

  const handleCelsiusChange = (value: number | "") => {
    setCelsius(value);
    setFahrenheit(
      value === "" ? "" : Number(((value * 9) / 5 + 32).toFixed(2))
    );
  };

  const handleFahrenheitChange = (value: number | "") => {
    setFahrenheit(value);
    setCelsius(value === "" ? "" : Number((((value - 32) * 5) / 9).toFixed(2)));
  };

  return (
    <div className="app-container">
      <h1>🌡️ Temperature Converter</h1>

      <div className="converter-card">
        <CelsiusInput value={celsius} onChange={handleCelsiusChange} />
        <FahrenheitInput value={fahrenheit} onChange={handleFahrenheitChange} />
      </div>
    </div>
  );
};

export default App;
