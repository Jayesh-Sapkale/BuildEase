import React, { useEffect } from "react";
import PropTypes from "prop-types";
import "./about.css";

import img1 from "../../assets/image27.jpeg";

const About = (props) => {
  useEffect(() => {
    window.scrollTo(0, 0);
  }, []);

  return (
    <div className="about-section">
      <div className="about-container">
        <div className="about-image-container">
          <img
            alt={props.imageAlt}
            src={props.imageSrc}
            className="about-image"
          />
        </div>
        <div className="about-content">
          <h2 className="about-heading">{props.title}</h2>
          <p className="about-description" style={{ whiteSpace: "pre-line" }}>
            {props.description}
          </p>
        </div>
      </div>
    </div>
  );
};

About.defaultProps = {
  imageSrc: img1, // Replace with your default image path
  imageAlt: "About Us Image",
  title: "About Our Company",
  description:
    "Company Overview : BuildEase Constructions is a leading name in the construction industry, renowned for its commitment to excellence, innovation, and customer satisfaction. Established over two decades ago, the company has grown from a small regional contractor to a national powerhouse, delivering a wide range of construction services across multiple sectors, including residential, commercial, industrial, and infrastructure development. With a rich history of successful projects and a future-focused approach, BuildEase Constructions continues to shape the skylines of cities and the landscapes of communities across the country.\n\n Our Vision and Mission : At BuildEase Constructions, our vision is to be the most trusted and respected construction company, recognized for our quality, integrity, and innovative solutions. We strive to set new benchmarks in the industry by consistently delivering superior projects that exceed client expectations. Our mission is to build environments that enrich lives, whether it's constructing homes, workplaces, or public spaces. We believe that every project we undertake has the potential to improve the lives of those who use it, and we take that responsibility seriously. \n\nOur Team : The strength of BuildEase Constructions lies in our people. Our team is composed of experienced professionals who bring a wealth of knowledge and expertise to every project. From architects and engineers to project managers and skilled tradespeople, every member of our team is dedicated to delivering excellence. We invest in continuous training and development to ensure that our team stays ahead of industry advancements and maintains the highest standards of craftsmanship.",
};

About.propTypes = {
  imageAlt: PropTypes.string,
  imageSrc: PropTypes.string,
  title: PropTypes.string,
  description: PropTypes.string,
};

export default About;
