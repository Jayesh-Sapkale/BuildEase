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
  const [selectedTab, setSelectedTab] = useState("My Work"); // Default tab

  // Initialize with default values
  const [pendingRequests, setPendingRequests] = useState([]);
  const [myWork, setMyWork] = useState([]);
  const [builderReviews, setBuilderReviews] = useState([]); // New state for reviews
  const [loading, setLoading] = useState(true); // Loading state
  const url = "http://localhost:8081";

  const fetchPendingRequests = async () => {
    try {
      const response = await axios.get(`${url}/builder/getPendingProjects`);
      setPendingRequests(response.data);
    } catch (error) {
      console.error("Error fetching pending requests data:", error.response ? error.response.data : error.message);
      toast.error("Error fetching pending requests data.");
    }
  };

  const fetchMyWork = async () => {
    try {
      const response = await axios.get(`${url}/builder/getCurrentProjects`);
      setMyWork(response.data);
    } catch (error) {
      console.error("Error fetching my work data:", error.response ? error.response.data : error.message);
      toast.error("Error fetching my work data.");
    }
  };

  const fetchBuilderReviews = async () => {
    try {
      const response = await axios.get(`${url}/admin/getAllBuilderReviews`);
      setBuilderReviews(response.data);
    } catch (error) {
      console.error("Error fetching builder reviews data:", error.response ? error.response.data : error.message);
      toast.error("Error fetching builder reviews data.");
    }
  };

  useEffect(() => {
    const loadData = async () => {
      setLoading(true);
      await Promise.all([fetchPendingRequests(), fetchMyWork(), fetchBuilderReviews()]);
      setLoading(false);
    };

    loadData();
  }, []);

  const handleStatusChange = async (id, accepted) => {
    try {

      await axios.put(`${url}/builder/updateProjectRequestStatusByBuilderId/${id}/${accepted}`);

      // Refetch data after the status update
      await Promise.all([fetchPendingRequests(), fetchMyWork()]);

      // Show success toast
      toast.success(`Project ${accepted ? "accepted" : "rejected"} successfully!`);

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
          {loading ? (
            <p>Loading...</p>
          ) : (
            <Table
              data={
                selectedTab === "My Work"
                  ? myWork
                  : selectedTab === "Pending Requests"
                    ? pendingRequests
                    : builderReviews // For the "Builder Reviews" tab
              }
              onStatusChange={selectedTab === "Pending Requests" ? handleStatusChange : null}
              tab={selectedTab}
            />
          )}
        </main>

        <ToastContainer />
      </div>
    </div>
  );
};

export default BuilderPortfolio;
