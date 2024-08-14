import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import "./builderPortfolio.css";

const BuilderPortfolio = () => {
  const history = useHistory();
  const [menuOpen, setMenuOpen] = useState(false);
  const [selectedTab, setSelectedTab] = useState("Current Work"); // Default tab

  const toggleMenu = () => {
    setMenuOpen((prevState) => !prevState);
  };

  const handleTabChange = (tab) => {
    setSelectedTab(tab);
    setMenuOpen(false);
  };

  return (
    <div className="builder-portfolio">
      <div className="builder-portfolio-container">
        <header className="builder-portfolio-header">
          <div className="builder-portfolio-back-button-container">
            <button id="back-button" onClick={() => history.goBack()}>
              ⬅
            </button>
          </div>
          <div className="builder-portfolio-title-container">
            <h1>Builder Portfolio</h1>
          </div>
          <div className="builder-portfolio-hamburger-menu-container">
            <button id="hamburger-menu" onClick={toggleMenu}>
              ☰
            </button>
          </div>
        </header>

        {menuOpen && (
          <nav className="BuilderDropdown-menu">
            <ul>
              <li onClick={() => handleTabChange("Current Work")}>
                Current Work
              </li>
              <li onClick={() => handleTabChange("Previous Work")}>
                Previous Work
              </li>
              <li onClick={() => history.push("/signout")}>Sign Out</li>
            </ul>
          </nav>
        )}

        <main className="builder-portfolio-main">
          {selectedTab === "Current Work" && (
            <section className="builder-portfolio-section">
              <h2>Current Work</h2>
              <div className="builder-portfolio-table-container">
                <table className="builder-portfolio-table">
                  <thead>
                    <tr>
                      <th>PID</th>
                      <th>Current Work Name</th>
                      <th>Status</th>
                      <th>Location</th>
                      <th>Date of Project</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        <a href="project1.html">001</a>
                      </td>
                      <td>Project Alpha</td>
                      <td>In Progress</td>
                      <td>Location A</td>
                      <td className="date-column">01 Aug 2024</td>
                      <td className="action-buttons">
                        <button className="accept">Accept</button>
                        <button className="decline">Decline</button>
                      </td>
                    </tr>
                    <tr>
                      <td>
                        <a href="project2.html">002</a>
                      </td>
                      <td>Project Beta</td>
                      <td>Completed</td>
                      <td>Location B</td>
                      <td className="date-column">05 Aug 2024</td>
                      <td className="action-buttons">
                        <button className="accept">Accept</button>
                        <button className="decline">Decline</button>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
          )}

          {selectedTab === "Previous Work" && (
            <section className="builder-portfolio-section">
              <h2>Previous Work</h2>
              <div className="builder-portfolio-table-container">
                <table className="builder-portfolio-table">
                  <thead>
                    <tr>
                      <th>PID</th>
                      <th>Previous Work Name</th>
                      <th>Status</th>
                      <th>Location</th>
                      <th>Date of Project</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>
                        <a href="previous1.html">A01</a>
                      </td>
                      <td>Old Project X</td>
                      <td>Completed</td>
                      <td>Location X</td>
                      <td className="date-column">15 Jun 2023</td>
                    </tr>
                    <tr>
                      <td>
                        <a href="previous2.html">A02</a>
                      </td>
                      <td>Old Project Y</td>
                      <td>Completed</td>
                      <td>Location Y</td>
                      <td className="date-column">20 Jun 2023</td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
          )}

          {/* <section className="builder-portfolio-reminder-section">
            <h2>Deadline Reminders</h2>
            <ul className="builder-portfolio-reminder-list">
              <li className="reminder-item">
                Project Alpha - Deadline: 15th August
              </li>
              <li className="reminder-item">
                Project Beta - Deadline: 20th August
              </li>
            </ul>
          </section> */}
        </main>
      </div>
    </div>
  );
};

export default BuilderPortfolio;
