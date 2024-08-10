import React, { useState } from "react";
import { useHistory } from "react-router-dom";
import "./adminPortfolio.css";

const AdminPortfolio = () => {
  const history = useHistory();
  const [isMenuVisible, setIsMenuVisible] = useState(false);
  const [currentView, setCurrentView] = useState('projects'); // Default view is 'projects'

  const handleMenuClick = (view) => {
    setCurrentView(view);
    setIsMenuVisible(false);
  };

  const handleConfirmClick = () => {
    // Add your confirmation logic here
    console.log("Confirm button clicked");
    alert("Confirm action performed.");
  };

  const handleOtpClick = () => {
    // Add your OTP logic here
    console.log("OTP button clicked");
    alert("OTP action performed.");
  };

  const handleEdit = (id) => {
    // Logic for editing item with the given id
    console.log(`Edit button clicked for item with ID: ${id}`);
  };

  const handleDelete = (id) => {
    // Logic for deleting item with the given id
    console.log(`Delete button clicked for item with ID: ${id}`);
    if (window.confirm("Are you sure you want to delete this item?")) {
      // Perform the delete operation
      console.log(`Item with ID: ${id} deleted.`);
    }
  };

  const handleView = (id) => {
    // Logic for viewing details of item with the given id
    console.log(`View button clicked for item with ID: ${id}`);
    // You can navigate to a detailed view or display more information
  };

  return (
    <div>
      {/* Header */}
      <header>
        <button id="back-button" onClick={() => history.goBack()}>Back</button>
        <h1>Admin Portfolio</h1>
        <button id="settings" onClick={() => setIsMenuVisible(!isMenuVisible)}>
          &#9776; {/* Hamburger icon */}
        </button>
        {isMenuVisible && (
          <div className="settings-menu visible">
            <ul>
              <li><a href="#users" onClick={() => handleMenuClick('users')}>List of Users</a></li>
              <li><a href="#builders" onClick={() => handleMenuClick('builders')}>List of Builders</a></li>
              <li><a href="#projects" onClick={() => handleMenuClick('projects')}>Project Table</a></li>
              <li><a href="#signout" onClick={() => handleMenuClick('signout')}>Sign Out</a></li>
            </ul>
          </div>
        )}
      </header>

      {/* Main Content */}
      <main>
        {currentView === 'users' && (
          <div className="table-container">
            {/* Users Table */}
            <section>
              <h2>List of Users</h2>
              <div className="table-wrapper">
                <table>
                  <thead>
                    <tr>
                      <th>User ID</th>
                      <th>Name</th>
                      <th>Project Description</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><a href="user1.html">1</a></td>
                      <td>John Doe</td>
                      <td>Project Alpha</td>
                      <td>Active</td>
                      <td>
                        <div className="action-buttons">
                          <button className="button edit-btn" onClick={() => handleEdit(1)}>Edit</button>
                          <button className="button delete-btn" onClick={() => handleDelete(1)}>Delete</button>
                          <button className="button view-btn" onClick={() => handleView(1)}>View</button>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
          </div>
        )}

        {currentView === 'builders' && (
          <div className="table-container">
            {/* Builders Table */}
            <section>
              <h2>List of Builders</h2>
              <div className="table-wrapper">
                <table>
                  <thead>
                    <tr>
                      <th>Builder ID</th>
                      <th>Name</th>
                      <th>Sites</th>
                      <th>Status</th>
                      <th>Action</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td><a href="builder1.html">1</a></td>
                      <td>Builder Inc.</td>
                      <td>Site A</td>
                      <td>Active</td>
                      <td>
                        <div className="action-buttons">
                          <button className="button edit-btn" onClick={() => handleEdit(1)}>Edit</button>
                          <button className="button delete-btn" onClick={() => handleDelete(1)}>Delete</button>
                          <button className="button view-btn" onClick={() => handleView(1)}>View</button>
                        </div>
                      </td>
                    </tr>
                  </tbody>
                </table>
              </div>
            </section>
          </div>
        )}

        {currentView === 'projects' && (
          <div className="table-container">
            {/* Projects Table */}
            <section>
              <h2>Project Table</h2>
              <div className="table-wrapper">
                <table>
                  <thead>
                    <tr>
                      <th>Project ID</th>
                      <th>User</th>
                      <th>Builder</th>
                      <th>Project Date</th>
                      <th>Status</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td>1</td>
                      <td>John Doe</td>
                      <td>Builder Inc.</td>
                      <td>2024-08-08</td>
                      <td>Allocated</td>
                    </tr>
                    {/* Add more rows as needed */}
                  </tbody>
                </table>
              </div>
            </section>
          </div>
        )}

        {currentView === 'signout' && (
          <div className="table-container">
            <section>
              <h2>Sign Out</h2>
              <p>You have been signed out. Please <a href="/login">log in again</a>.</p>
            </section>
          </div>
        )}

        {/* Footer Buttons */}
        {(currentView === 'users' || currentView === 'builders') && (
          <div className="footer-buttons">
            <button className="button confirm-btn" onClick={handleConfirmClick}>Confirm</button>
            <button className="button otp-btn" onClick={handleOtpClick}>OTP</button>
          </div>
        )}
      </main>
    </div>
  );
};

export default AdminPortfolio;












