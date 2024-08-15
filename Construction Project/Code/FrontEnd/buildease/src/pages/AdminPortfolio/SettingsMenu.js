import React from "react";

const SettingsMenu = ({ onMenuClick }) => {
    return (
        <div className="settings-menu visible">
            <ul>
                <li>
                    <a href="#users" onClick={() => onMenuClick("users")}>
                        List of Users
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
