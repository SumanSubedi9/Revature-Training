"use strict";

const catBtn = document.getElementById("catBtn");
const catImg = document.getElementById("catImg");

// Event listener for button click with async/await and try/catch/finally

catBtn.addEventListener("click", async () => {
  try {
    catBtn.textContent = "Loading......🐈"; // Change button text while loading
    const response = await fetch("https://cataas.com/cat"); // Fetch random cat image
    catImg.src = "https://cataas.com/cat?" + new Date().getTime(); // Update image source with cache buster
  } catch (error) {
    console.error("Error fetching cat image:", error); // Log any errors
  } finally {
    catBtn.textContent = "Get Random Cat 🐈"; // Reset button text
  }
});
