// src/components/SideMenu.js
import React from 'react';
//import './SideMenu.css'; // Import the CSS file for the SideMenu component

const SideMenu = ({ sidenavOpen, onMenuClick, onClose }) => {
  return (
    <div className="sidenav-container">
      <nav className={`sidenav ${sidenavOpen ? 'active' : ''}`}>
        <a href="#" onClick={() => onMenuClick('create')} className="sidenav-link">Create Project</a>
        <a href="#" onClick={() => onMenuClick('update')} className="sidenav-link">Update Project</a>
        <a href="#" onClick={() => onMenuClick('current')} className="sidenav-link">Current Project</a>
        <div className="confirm-cancel-buttons">
          <button className="cancel-btn" onClick={onClose}>Cancel</button>
        </div>
      </nav>
    </div>
  );
};

export default SideMenu;
