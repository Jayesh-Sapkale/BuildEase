// Dropdown.js
import React from "react";
import "./Dropdown.css"; // Import the CSS file for dropdown styles

const Dropdown = ({ isOpen, toggleDropdown }) => {
  return (
    <div className={`dropdown ${isOpen ? "show" : ""}`}>
      <button className="btn btn-settings" onClick={toggleDropdown}>
        <i className="fas fa-cog"></i>
      </button>
      <div className={`dropdown-menu ${isOpen ? "show" : ""}`}>
        <a href="/logout" className="dropdown-item">
          Logout
        </a>
      </div>
    </div>
  );
};

export default Dropdown;
