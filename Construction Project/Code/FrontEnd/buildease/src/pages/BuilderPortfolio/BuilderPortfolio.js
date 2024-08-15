import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css"; // Import Toastify CSS
import "./builderPortfolio.css";

const BuilderPortfolio = () => {
  const history = useHistory();
  const [menuOpen, setMenuOpen] = useState(false);
  const [selectedTab, setSelectedTab] = useState("Current Work"); // Default tab

  const [currentWork, setCurrentWork] = useState([]);
  const [previousWork, setPreviousWork] = useState([]);

  const url = "http://localhost:8081";

  const fetchCurrentWork = async () => {
    try {
      const response = await axios.get(`${url}/builder/getCurrentProjects`);
      console.log("Current Work Data:", response.data); // Debugging log
      setCurrentWork(response.data);
    } catch (error) {
      console.error("Error fetching current work data:", error.response ? error.response.data : error.message);
    }
  };

  const fetchPreviousWork = async () => {
    try {
      const response = await axios.get(`${url}/builder/getPreviousProjects`);
      console.log("Previous Work Data:", response.data); // Debugging log
      setPreviousWork(response.data);
    } catch (error) {
      console.error("Error fetching previous work data:", error.response ? error.response.data : error.message);
    }
  };

  useEffect(() => {
    fetchCurrentWork();
    fetchPreviousWork();
  }, []);

  const handleStatusChange = async (id, accepted) => {
    try {
      await axios.put(`${url}/builder/updateProjectRequestStatusByBuilderId/${id}/${accepted}`);

      // Update state locally for current work
      const updatedCurrentWork = currentWork.map((work) =>
        work.projectId === id
          ? { ...work, projectStatus: accepted ? "true" : "false" }
          : work
      );
      setCurrentWork(updatedCurrentWork);

      // Optionally, refetch the data or update previous work state similarly
      // await fetchCurrentWork(); // Uncomment if you want to refetch data
      // await fetchPreviousWork(); // Uncomment if you want to refetch data

      // Show success toast
      toast.success(`Project ${accepted ? "accepted" : "declined"} successfully!`);
    } catch (error) {
      console.error("Error updating work status:", error.response ? error.response.data : error.message);
      toast.error("Error updating project status. Please try again.");
    }
  };

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
                      <th>Project Details Id</th>
                      <th>Builder Name</th>
                      <th>Customer Name</th>
                      <th>Construction Type</th>
                      <th>City</th>
                      <th>Project Name</th>
                      <th>Project Status</th>
                      <th>Request Status</th>
                    </tr>
                  </thead>
                  <tbody>
                    {currentWork.map((work) => (
                      <tr key={work.projectId}>
                        <td>{work.projectId}</td>
                        <td>{work.builderName}</td>
                        <td>{work.customerName}</td>
                        <td>{work.constructionType}</td>
                        <td>{work.city}</td>
                        <td>{work.projectName}</td>
                        <td>{work.projectStatus}</td>
                        <td>{work.requestStatus}</td>

                      </tr>
                    ))}
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
                      <th>Project Details Id</th>
                      <th>Builder Name</th>
                      <th>Customer Name</th>
                      <th>Construction Type</th>
                      <th>City</th>
                      <th>Project Name</th>
                      <th>Project Status</th>
                      <th>Request Status</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    {previousWork.map((work) => (
                      <tr key={work.projectId}>
                        <td>{work.projectId}</td>
                        <td>{work.builderName}</td>
                        <td>{work.customerName}</td>
                        <td>{work.constructionType}</td>
                        <td>{work.city}</td>
                        <td>{work.projectName}</td>
                        <td>{work.projectStatus}</td>
                        <td>{work.requestStatus}</td>
                        <td className="action-buttons">
                          {work.projectStatus !== "Accepted" && work.projectStatus !== "Declined" && (
                            <>
                              <button
                                className="accept"
                                onClick={() => handleStatusChange(work.projectId, true)}
                              >
                                Accept
                              </button>
                              <button
                                className="decline"
                                onClick={() => handleStatusChange(work.projectId, false)}
                              >
                                Decline
                              </button>
                            </>
                          )}
                        </td>
                      </tr>
                    ))}
                  </tbody>
                </table>
              </div>
            </section>
          )}
        </main>

        <ToastContainer /> {/* Add this line to display Toastify notifications */}
      </div>
    </div>
  );
};

export default BuilderPortfolio;
