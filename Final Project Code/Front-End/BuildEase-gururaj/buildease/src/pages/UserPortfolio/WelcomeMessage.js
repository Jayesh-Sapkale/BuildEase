// src/components/WelcomeMessage.js
import React from "react";
import WelcomeCards from "./WelcomeCards"; // Import the new component
import "./WelcomeMessage.css"; // Import CSS for styling

const WelcomeMessage = () => {
  return (
    <div className="welcome-message">
      <h2>Let's Explore!</h2>
      <WelcomeCards /> {/* Include the WelcomeCards component */}
    </div>
  );
};

export default WelcomeMessage;
