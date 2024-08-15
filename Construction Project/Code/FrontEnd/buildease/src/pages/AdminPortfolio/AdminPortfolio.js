import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import SettingsMenu from "./SettingsMenu";
import CustomersTable from "./Tables/CustomersTable";
import BuildersTable from "./Tables/BuildersTable";
import ProjectsTable from "./Tables//ProjectsTable";
import AdminsTable from "./Tables/AdminsTable";
import SignOut from "./SignOut";
import "./adminPortfolio.css";

const AdminPortfolio = () => {
  const history = useHistory();
  const [isMenuVisible, setIsMenuVisible] = useState(false);
  const [currentView, setCurrentView] = useState("admins"); // Default view is 'projects'

  const handleMenuClick = (view) => {
    setCurrentView(view);
    setIsMenuVisible(false);
  };

  const handleConfirmClick = () => {
    console.log("Confirm button clicked");
    alert("Confirm action performed.");
  };

  return (
    <div className="admin-portfolio">
      {/* Header */}
      <header>
        <button id="back-button" onClick={() => history.goBack()}>
          ⬅
        </button>
        <h1>Admin Portfolio</h1>
        <button id="settings" onClick={() => setIsMenuVisible(!isMenuVisible)}>
          &#9776; {/* Hamburger icon */}
        </button>
        {isMenuVisible && <SettingsMenu onMenuClick={handleMenuClick} />}
      </header>

      {/* Main Content */}
      <main>
        {currentView === "admins" && <AdminsTable />}
        {currentView === "customers" && <CustomersTable />}
        {currentView === "builders" && <BuildersTable />}
        {currentView === "projects" && <ProjectsTable />}
        {currentView === "signout" && <SignOut />}

        {/* Footer Buttons */}
        {(currentView === "customers" || currentView === "builders") && (
          <div className="footer-buttons">
            <button className="button confirm-btn" onClick={handleConfirmClick}>
              Confirm
            </button>
            {/* Uncomment if needed
            <button className="button otp-btn" onClick={handleOtpClick}>
              OTP
            </button>
            */}
          </div>
        )}
      </main>
    </div>
  );
};

export default AdminPortfolio;
