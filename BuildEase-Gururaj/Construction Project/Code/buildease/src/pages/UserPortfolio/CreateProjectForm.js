import React, { useState, useEffect } from "react";
import axios from "axios";
import "./CreateProjectForm.css";
import HouseDetailsForm from "./HouseDetailsForm";

const CreateProjectForm = ({ customerId, onCreate }) => {
  const [projectName, setProjectName] = useState("");
  const [builderName, setBuilderName] = useState("");
  const [builderId, setBuilderId] = useState(null); // New state to store builder ID
  const [startDate, setStartDate] = useState("");
  const [endDate, setEndDate] = useState("");
  const [projectStatus, setProjectStatus] = useState("IN_PROGRESS");
  const [projectDescription, setProjectDescription] = useState("");
  const [areaInSqFt, setAreaInSqFt] = useState(0);
  const [constructionType, setConstructionType] = useState("WAREHOUSE");
  const [constructionDescription, setConstructionDescription] = useState("");
  const [adrLine1, setAdrLine1] = useState("");
  const [adrLine2, setAdrLine2] = useState("");
  const [city, setCity] = useState("");
  const [state, setState] = useState("");
  const [country, setCountry] = useState("");
  const [zipcode, setZipcode] = useState("");
  const [builders, setBuilders] = useState([]);
  const [showHouseDetails, setShowHouseDetails] = useState(false);

  const url = "http://localhost:8081";

  // Fetch builders on component mount
  useEffect(() => {
    const fetchBuilders = async () => {
      try {
        const response = await axios.get(`${url}/admin/getAllBuilders`);
        setBuilders(response.data);
      } catch (error) {
        console.error("Error fetching builders:", error);
      }
    };

    fetchBuilders();
  }, []);

  const handleBuilderChange = (e) => {
    const selectedBuilderId = e.target.value;
    const selectedBuilder = builders.find((builder) => builder.id === parseInt(selectedBuilderId));
    if (selectedBuilder) {
      setBuilderId(selectedBuilder.id);
      setBuilderName(selectedBuilder.name);
    }
  };

  const handleSubmit = async (e) => {
    e.preventDefault();

    const projectData = {
      projectName,
      builderName,
      startDate,
      endDate,
      projectStatus,
      projectDescription,
      constructionDetails: {
        areaInSqFt,
        constructionType,
        constructionDescription,
      },
      address: {
        adrLine1,
        adrLine2,
        city,
        state,
        country,
        zipcode,
      },
    };

    try {
      // Use the customerId and builderId in the POST request
      const response = await axios.post(
        `${url}/project/addNewProject/${customerId}/${builderId}`,
        projectData
      );
      console.log("Project created:", response.data);

      setShowHouseDetails(true);
    } catch (error) {
      console.error("Error during project creation:", error);
    }
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
                  <select
                    id="builderName"
                    className="form-select"
                    value={builderId || ""}
                    onChange={handleBuilderChange}
                    required
                  >
                    <option value="" disabled>
                      Select Builder
                    </option>
                    {builders.map((builder) => (
                      <option key={builder.id} value={builder.id}>
                        {builder.name}
                      </option>
                    ))}
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
                  <label htmlFor="areaInSqFt" className="form-label">
                    Area in Sq Ft
                  </label>
                </td>
                <td>
                  <input
                    type="number"
                    id="areaInSqFt"
                    className="form-control"
                    value={areaInSqFt}
                    onChange={(e) => setAreaInSqFt(e.target.value)}
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
                    <option value="WAREHOUSE">Warehouse</option>
                    <option value="HOUSE">House</option>
                    <option value="APARTMENT">Apartment</option>
                    <option value="MALL">Mall</option>
                  </select>
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="constructionDescription" className="form-label">
                    Construction Description
                  </label>
                </td>
                <td>
                  <textarea
                    id="constructionDescription"
                    className="form-control"
                    value={constructionDescription}
                    onChange={(e) => setConstructionDescription(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="adrLine1" className="form-label">
                    Address Line 1
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="adrLine1"
                    className="form-control"
                    value={adrLine1}
                    onChange={(e) => setAdrLine1(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="adrLine2" className="form-label">
                    Address Line 2
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="adrLine2"
                    className="form-control"
                    value={adrLine2}
                    onChange={(e) => setAdrLine2(e.target.value)}
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="city" className="form-label">
                    City
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="city"
                    className="form-control"
                    value={city}
                    onChange={(e) => setCity(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="state" className="form-label">
                    State
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="state"
                    className="form-control"
                    value={state}
                    onChange={(e) => setState(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="country" className="form-label">
                    Country
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="country"
                    className="form-control"
                    value={country}
                    onChange={(e) => setCountry(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="zipcode" className="form-label">
                    Zipcode
                  </label>
                </td>
                <td>
                  <input
                    type="text"
                    id="zipcode"
                    className="form-control"
                    value={zipcode}
                    onChange={(e) => setZipcode(e.target.value)}
                    required
                  />
                </td>
              </tr>

              <button type="submit" className="btn btn-primary">
                Create Project
              </button>
            </tbody>
          </table>
        </form>
      ) : (
        <HouseDetailsForm projectName={projectName} />
      )}
    </>
  );
};

export default CreateProjectForm;
