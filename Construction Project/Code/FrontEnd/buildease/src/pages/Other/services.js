import React, { useEffect } from "react";
import { useHistory } from "react-router-dom";
import "./services.css";
// import Img1 from "../assets/image11.jpg";
import Img1 from "../../assets/image31.jpeg";

export default function Services() {
  const history = useHistory();

  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  return (
    <div className="servicesWrapper">
      <div className="headerContainer">
        {/* <button className="backButton" onClick={() => history.goBack()}>
          Back
        </button> */}
        <br />
        <br />
        <h2 className="title">Our Services</h2>
      </div>
      <div className="servicesContainer">
        <div className="textContainer">
          <div className="servicesList">
            <div
              className="serviceItem"
              onClick={() => history.push("/admin-portfolio")}
            >
              <h3>Admin Portfolio</h3>
              <p>Manage and view all administrative portfolios.</p>
            </div>
            <div
              className="serviceItem"
              onClick={() => history.push("/builder-portfolio")}
            >
              <h3>Builder Portfolio</h3>
              <p>Access builder portfolios and project details.</p>
            </div>
            <div
              className="serviceItem"
              onClick={() => history.push("/user-portfolio")}
            >
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
    </div>
  );
}
