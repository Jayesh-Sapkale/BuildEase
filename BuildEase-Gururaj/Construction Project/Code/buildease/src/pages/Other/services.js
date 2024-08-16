import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import "./services.css";
import Img1 from "../../assets/image31.jpeg";
import SignIn from "../SignIn_SignUp/signin"; // Adjust the import path as needed

export default function Services() {
  const history = useHistory();
  const [showSignIn, setShowSignIn] = useState(false);

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  const handleServiceClick = () => {
    setShowSignIn(true);
  };

  const handleCloseSignIn = () => {
    setShowSignIn(false);
  };

  return (
    <div className={`servicesWrapper ${showSignIn ? "blurred" : ""}`}>
      <div className="headerContainer">
        <br />
        <br />
        <h2 className="title">Our Services</h2>
      </div>
      <div className="servicesContainer">
        <div className="textContainer">
          <div className="servicesList">
            <div className="serviceItem" onClick={handleServiceClick}>
              <h3>Admin Portfolio</h3>
              <p>Manage and view all administrative portfolios.</p>
            </div>
            <div className="serviceItem" onClick={handleServiceClick}>
              <h3>Builder Portfolio</h3>
              <p>Access builder portfolios and project details.</p>
            </div>
            <div className="serviceItem" onClick={handleServiceClick}>
              <h3>User Portfolio</h3>
              <p>View and manage user portfolios and related information.</p>
            </div>
          </div>
        </div>
        <div className="imageContainer">
          <img
            src={Img1}
            alt="Services Illustration"
            className="servicesImage"
          />
        </div>
      </div>
      {showSignIn && (
        <div className="overlay">
          <SignIn closeSignIn={handleCloseSignIn} />
        </div>
      )}
    </div>
  );
}
