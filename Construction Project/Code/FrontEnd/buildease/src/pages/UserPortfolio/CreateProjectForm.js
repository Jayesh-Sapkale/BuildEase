import React, { useState } from "react";
import "./CreateProjectForm.css"; // Import the CSS file
import HouseDetailsForm from "./HouseDetailsForm"; // Import the new component

const CreateProjectForm = ({ onCreate }) => {
  const [projectName, setProjectName] = useState("");
  const [builderName, setBuilderName] = useState("");
  const [location, setLocation] = useState("");
  const [constructionType, setConstructionType] = useState("");
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [projectDescription, setProjectDescription] = useState("");
  const [totalPrice, setTotalPrice] = useState("");
  const [showHouseDetails, setShowHouseDetails] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    onCreate({
      projectName,
      builderName,
      location,
      constructionType,
      startDate,
      endDate,
      projectDescription,
      totalPrice,
    });
    setShowHouseDetails(true);
  };

  return (
    <>
      {!showHouseDetails ? (
        <form onSubmit={handleSubmit} className="create-project-form">
          <table className="form-table">
            <tbody>
              <tr>
                <td>
                  <label htmlFor="projectName" className="form-label">
                    Project Name
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="projectName"
                    className="form-control"
                    value={projectName}
                    onChange={(e) => setProjectName(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="builderName" className="form-label">
                    Builder Name
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="builderName"
                    className="form-control"
                    value={builderName}
                    onChange={(e) => setBuilderName(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="location" className="form-label">
                    Location
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="location"
                    className="form-control"
                    value={location}
                    onChange={(e) => setLocation(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="constructionType" className="form-label">
                    Construction Type
                  </label>
                </td>
                <td>
                  <select
                    id="constructionType"
                    className="form-select"
                    value={constructionType}
                    onChange={(e) => setConstructionType(e.target.value)}
                    required
                  >
                    <option value="" disabled>
                      Select Type
                    </option>
                    <option value="WAREHOUSE">Warehouse</option>
                    <option value="HOUSE">House</option>
                    <option value="APARTMENT">Apartment</option>
                    <option value="MALL">Mall</option>
                  </select>
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="startDate" className="form-label">
                    Start Date
                  </label>
                </td>
                <td>
                  <input
                    type="date"
                    id="startDate"
                    className="form-control"
                    value={startDate}
                    onChange={(e) => setStartDate(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="endDate" className="form-label">
                    End Date
                  </label>
                </td>
                <td>
                  <input
                    type="date"
                    id="endDate"
                    className="form-control"
                    value={endDate}
                    onChange={(e) => setEndDate(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="projectDescription" className="form-label">
                    Project Description
                  </label>
                </td>
                <td>
                  <textarea
                    id="projectDescription"
                    className="form-control"
                    value={projectDescription}
                    onChange={(e) => setProjectDescription(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="totalPrice" className="form-label">
                    Total Price
                  </label>
                </td>
                <td>
                  <input
                    type="number"
                    id="totalPrice"
                    className="form-control"
                    value={totalPrice}
                    onChange={(e) => setTotalPrice(e.target.value)}
                    required
                  />
                </td>
              </tr>
            </tbody>
          </table>

          <button type="submit" className="form-submit-btn">
            Create Project
          </button>
        </form>
      ) : (
        <HouseDetailsForm onSubmit={() => setShowHouseDetails(false)} />
      )}
    </>
  );
};

export default CreateProjectForm;
