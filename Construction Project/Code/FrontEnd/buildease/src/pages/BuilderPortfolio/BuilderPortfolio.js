import React, { useState, useEffect } from "react";
import { useHistory } from "react-router-dom";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import Header from "./Header";
import Menu from "./Menu";
import Table from "./Table";
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
      setCurrentWork(response.data);
    } catch (error) {
      console.error("Error fetching current work data:", error.response ? error.response.data : error.message);
    }
  };

  const fetchPreviousWork = async () => {
    try {
      const response = await axios.get(`${url}/builder/getPreviousProjects`);
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

      // Refetch data after the status update
      if (selectedTab === "Current Work") {
        await fetchCurrentWork();
      } else if (selectedTab === "Previous Work") {
        await fetchPreviousWork();
      }

      // Show success toast
      toast.success(`Project ${accepted ? "accepted" : "declined"} successfully!`);
    } catch (error) {
      console.error("Error updating work status:", error.response ? error.response.data : error.message);
      toast.error("Error updating project status. Please try again.");
    }
  };

  const toggleMenu = () => {
    setMenuOpen(prevState => !prevState);
  };

  const handleTabChange = (tab) => {
    setSelectedTab(tab);
    setMenuOpen(false);
  };

  return (
    <div className="builder-portfolio">
      <div className="builder-portfolio-container">
        <Header history={history} toggleMenu={toggleMenu} />

        {menuOpen && (
          <Menu handleTabChange={handleTabChange} history={history} />
        )}

        <main className="builder-portfolio-main">
          <Table
            data={selectedTab === "Current Work" ? currentWork : previousWork}
            onStatusChange={handleStatusChange}
            tab={selectedTab}
          />
        </main>

        <ToastContainer />
      </div>
    </div>
  );
};

export default BuilderPortfolio;
