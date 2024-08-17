import React from 'react';

const Menu = ({ handleTabChange, history }) => {
    return (
        <nav className="BuilderDropdown-menu">
            <ul>
                <li onClick={() => handleTabChange("My Work")}>My Work</li>
                <li onClick={() => handleTabChange("Pending Requests")}>Pending Requests</li>
                <li onClick={() => handleTabChange("Reviews")}>Reviews</li>
                <li onClick={() => history.push("/")}>Sign Out</li>
            </ul>
        </nav>
    );
};

export default Menu;
