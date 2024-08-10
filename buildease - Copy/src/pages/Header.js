import React, { useState } from 'react';
import { BsGear, BsList } from 'react-icons/bs';
import './Header.css'; // Ensure this CSS file contains styles for the dropdown menu

const Header = ({ onMenuToggle, userName }) => {
  const [dropdownOpen, setDropdownOpen] = useState(false);

  const toggleDropdown = () => {
    setDropdownOpen(!dropdownOpen);
  };

  return (
    <header className="header d-flex justify-content-between align-items-center p-3 bg-primary text-white">
      <button id="menu-toggle" className="hamburger" onClick={onMenuToggle}>
        <BsList className="icon-hamburger" />
      </button>
      <h1>Welcome, {userName}</h1>
      <div className="header-buttons position-relative">
        <button className="btn" onClick={toggleDropdown}>
          <BsGear className="icon-settings" />
        </button>
        {/* Dropdown Menu */}
        {dropdownOpen && (
          <div className="dropdown-menu">
            <a href="/profile" onClick={() => setDropdownOpen(false)}>Profile</a>
            <a href="/logout" onClick={() => setDropdownOpen(false)}>Logout</a>
          </div>
        )}
      </div>
    </header>
  );
};

export default Header;
