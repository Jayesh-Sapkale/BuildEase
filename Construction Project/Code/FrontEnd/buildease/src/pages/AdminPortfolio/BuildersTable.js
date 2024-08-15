import React, { useState, useEffect } from "react";
import axios from "axios";

const BuildersTable = () => {
  const [builders, setBuilders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [editMode, setEditMode] = useState(false);
  const [selectedBuilder, setSelectedBuilder] = useState(null);
  const [formData, setFormData] = useState({
    yearsOfExperience: "",
    ratePerMonth: "",
    constructionType: "",
    emergencyContactNumber: "",
    availability: "",
  });
  const [successMessage, setSuccessMessage] = useState("");

  useEffect(() => {
    const fetchBuilders = async () => {
      try {
        const response = await axios.get("http://localhost:8081/admin/getAllBuilders");
        setBuilders(response.data);
      } catch (error) {
        setError(error.message || "An error occurred while fetching data.");
      } finally {
        setLoading(false);
      }
    };

    fetchBuilders();
  }, []);

  const handleEdit = (builder) => {
    setSelectedBuilder(builder);
    setFormData({
      yearsOfExperience: builder.yearsOfExperience || "",
      ratePerMonth: builder.ratePerMonth || "",
      constructionType: builder.constructionType || "",
      emergencyContactNumber: builder.emergencyContactNumber || "",
      availability: builder.availability || "",
      city: builder.city || ""
    });
    setEditMode(true);
    setSuccessMessage(""); // Clear any previous success message
  };

  const handleFormChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      // PUT request to update the builder's details
      const response = await axios.put(
        `http://localhost:8081/builder/updateBuilderById/${selectedBuilder.id}`,
        formData
      );
      console.log("Updated Builder Data:", response.data);

      // Update the builders list with the updated builder
      setBuilders((prevBuilders) =>
        prevBuilders.map((builder) =>
          builder.id === selectedBuilder.id ? response.data : builder
        )
      );

      // Set the success message
      setSuccessMessage("Builder details updated successfully!");

      // Reset the form and edit mode
      setEditMode(false);
      setSelectedBuilder(null);
    } catch (error) {
      console.error("Error updating builder:", error.message || "An error occurred.");
    }
  };

  const handleDelete = (id) => {
    console.log(`Delete button clicked for item with ID: ${id}`);
    if (window.confirm("Are you sure you want to delete this item?")) {
      console.log(`Item with ID: ${id} deleted.`);
    }
  };

  const handleView = (id) => {
    console.log(`View button clicked for item with ID: ${id}`);
  };

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <div className="table-container">
      <section>
        <h2>List of Builders</h2>
        {successMessage && <p className="success-message">{successMessage}</p>}
        <div className="table-wrapper">
          <table>
            <thead>
              <tr>
                <th>Builder ID</th>
                <th>Years of Experience</th>
                <th>Rate per Month</th>
                <th>Construction Type</th>
                <th>Emergency Contact Number</th>
                <th>Availability</th>
                <th>City</th>
                <th>Action</th>
              </tr>
            </thead>
            <tbody>
              {builders.length > 0 ? (
                builders.map((builder) => (
                  <tr key={builder.id}>
                    <td>{builder.id}</td>
                    <td>{builder.yearsOfExperience}</td>
                    <td>${builder.ratePerMonth.toFixed(2)}</td>
                    <td>{builder.constructionType}</td>
                    <td>{builder.emergencyContactNumber}</td>
                    <td>{builder.availability}</td>
                    <td>{builder.city}</td>
                    <td>
                      <div className="action-buttons">
                        <button
                          className="button edit-btn"
                          onClick={() => handleEdit(builder)}
                        >
                          Edit
                        </button>
                        <button
                          className="button delete-btn"
                          onClick={() => handleDelete(builder.id)}
                        >
                          Delete
                        </button>
                        <button
                          className="button view-btn"
                          onClick={() => handleView(builder.id)}
                        >
                          View
                        </button>
                      </div>
                    </td>
                  </tr>
                ))
              ) : (
                <tr>
                  <td colSpan="8">No builders available</td>
                </tr>
              )}
            </tbody>
          </table>
        </div>
      </section>

      {editMode && (
        <section>
          <h3>Edit Builder Details</h3>
          <form onSubmit={handleSubmit}>
            <div>
              <label htmlFor="yearsOfExperience">Years of Experience:</label>
              <input
                type="number"
                id="yearsOfExperience"
                name="yearsOfExperience"
                value={formData.yearsOfExperience}
                onChange={handleFormChange}
                required
              />
            </div>
            <div>
              <label htmlFor="ratePerMonth">Rate per Month:</label>
              <input
                type="number"
                id="ratePerMonth"
                name="ratePerMonth"
                value={formData.ratePerMonth}
                onChange={handleFormChange}
                required
              />
            </div>
            <div>
              <label htmlFor="constructionType">Construction Type:</label>
              <input
                type="text"
                id="constructionType"
                name="constructionType"
                value={formData.constructionType}
                onChange={handleFormChange}
                required
              />
            </div>
            <div>
              <label htmlFor="emergencyContactNumber">Emergency Contact Number:</label>
              <input
                type="text"
                id="emergencyContactNumber"
                name="emergencyContactNumber"
                value={formData.emergencyContactNumber}
                onChange={handleFormChange}
                required
                maxLength="10"
                minLength="10"
              />
            </div>
            <div>
              <label htmlFor="availability">Availability:</label>
              <input
                type="text"
                id="availability"
                name="availability"
                value={formData.availability}
                onChange={handleFormChange}
                required
              />
            </div>
            <button type="submit">Save Changes</button>
            <button
              type="button"
              onClick={() => {
                setEditMode(false);
                setSelectedBuilder(null);
                setSuccessMessage(""); // Clear any success message
              }}
            >
              Cancel
            </button>
          </form>
        </section>
      )}
    </div>
  );
};

export default BuildersTable;
