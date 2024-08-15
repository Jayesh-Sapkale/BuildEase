import React from "react";


const SettingsMenu = ({ onMenuClick }) => {
    return (
        <div className="settings-menu visible">
            <ul>
                <li>
                    <a href="#admins" onClick={() => onMenuClick("admins")}>
                        List of Admins
                    </a>
                </li>
                <li>
                    <a href="#customers" onClick={() => onMenuClick("customers")}>
                        List of Customers
                    </a>
                </li>
                <li>
                    <a href="#builders" onClick={() => onMenuClick("builders")}>
                        List of Builders
                    </a>
                </li>
                <li>
                    <a href="#projects" onClick={() => onMenuClick("projects")}>
                        Project Table
                    </a>
                </li>
                <li>
                    <a href="#signout" onClick={() => onMenuClick("signout")}>
                        Sign Out
                        
                    </a>
                </li>
            </ul>
        </div>
    );
};

export default SettingsMenu;
