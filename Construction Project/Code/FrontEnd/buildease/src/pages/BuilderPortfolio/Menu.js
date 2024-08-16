import React from 'react';

const Menu = ({ handleTabChange, history }) => {
    return (
        <nav className="BuilderDropdown-menu">
            <ul>
                <li onClick={() => handleTabChange("Current Work")}>Current Work</li>
                <li onClick={() => handleTabChange("Previous Work")}>Previous Work</li>
                <li onClick={() => history.push("/signout")}>Sign Out</li>
            </ul>
        </nav>
    );
};

export default Menu;
