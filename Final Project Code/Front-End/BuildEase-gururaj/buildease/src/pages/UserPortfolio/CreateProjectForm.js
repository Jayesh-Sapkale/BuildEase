import React, { useState } from "react";
import "./CreateProjectForm.css"; // Import the CSS file
import HouseDetailsForm from "./HouseDetailsForm"; // Import the new component

const CreateProjectForm = ({ onCreate }) => {
  const [builderName, setBuilderName] = useState("");
  const [customBuilderName, setCustomBuilderName] = useState("");
  const [location, setLocation] = useState("");
  const [budget, setBudget] = useState("");
  const [permit, setPermit] = useState("");
  const [startDate, setStartDate] = useState("");
  const [customStartDate, setCustomStartDate] = useState("");
  const [plotRegistered, setPlotRegistered] = useState("");
  const [floorArea, setFloorArea] = useState("");
  const [profession, setProfession] = useState("");
  const [customProfession, setCustomProfession] = useState("");
  const [showHouseDetails, setShowHouseDetails] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    const builder = builderName === "Other" ? customBuilderName : builderName;
    const start = startDate === "others" ? customStartDate : startDate;
    const prof = profession === "others" ? customProfession : profession;
    onCreate({
      builder,
      location,
      budget,
      permit,
      start,
      plotRegistered,
      floorArea,
      prof,
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
                  <label htmlFor="builderName" className="form-label">
                    Builder Name
                  </label>
                </td>
                <td>
                  <select
                    id="builderName"
                    className="form-select"
                    value={builderName}
                    onChange={(e) => setBuilderName(e.target.value)}
                    required
                  >
                    <option value="" disabled>
                      Select Builder
                    </option>
                    <option value="Om Prakash (Heights Co.)">Builder 1</option>
                    <option value="Shrishti Deshmuk (Unchai Constructions)">
                      Builder 2
                    </option>
                    <option value="Akash Shetty (Pune dream Home Construction)">
                      Builder 3
                    </option>
                    <option value="Other">Other</option>
                  </select>
                  {builderName === "Other" && (
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Enter builder name"
                      value={customBuilderName}
                      onChange={(e) => setCustomBuilderName(e.target.value)}
                      required
                    />
                  )}
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
                  <label className="form-label">What is your budget?</label>
                </td>
                <td>
                  <div className="form-check-group">
                    <label className="form-check">
                      <input
                        type="radio"
                        name="budget"
                        value="level1"
                        className="form-check-input"
                        onChange={(e) => setBudget(e.target.value)}
                        required
                      />
                      More than 2cr
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="budget"
                        value="level2"
                        className="form-check-input"
                        onChange={(e) => setBudget(e.target.value)}
                        required
                      />
                      1cr to 2cr
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="budget"
                        value="level3"
                        className="form-check-input"
                        onChange={(e) => setBudget(e.target.value)}
                        required
                      />
                      50L to 1cr
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="budget"
                        value="level4"
                        className="form-check-input"
                        onChange={(e) => setBudget(e.target.value)}
                        required
                      />
                      20L to 50L
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="budget"
                        value="level5"
                        className="form-check-input"
                        onChange={(e) => setBudget(e.target.value)}
                        required
                      />
                      Less than 20L
                    </label>
                  </div>
                </td>
              </tr>

              <tr>
                <td>
                  <label className="form-label">
                    Do you have a government permit to construct?
                  </label>
                </td>
                <td>
                  <div className="form-check-group">
                    <label className="form-check">
                      <input
                        type="radio"
                        name="permit"
                        value="YesIhave"
                        className="form-check-input"
                        onChange={(e) => setPermit(e.target.value)}
                        required
                      />
                      Yes I have a permit
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="permit"
                        value="Applied"
                        className="form-check-input"
                        onChange={(e) => setPermit(e.target.value)}
                        required
                      />
                      I have applied
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="permit"
                        value="YetToApply"
                        className="form-check-input"
                        onChange={(e) => setPermit(e.target.value)}
                        required
                      />
                      Yet to apply
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="permit"
                        value="No"
                        className="form-check-input"
                        onChange={(e) => setPermit(e.target.value)}
                        required
                      />
                      Permit not required
                    </label>
                  </div>
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="startDate" className="form-label">
                    When do you want to start the construction?
                  </label>
                </td>
                <td>
                  <select
                    id="startDate"
                    className="form-select"
                    value={startDate}
                    onChange={(e) => setStartDate(e.target.value)}
                    required
                  >
                    <option value="" disabled>
                      Select
                    </option>
                    <option value="immediately">Immediately</option>
                    <option value="within 3 months">Within 3 months</option>
                    <option value="within 6 months">Within 6 months</option>
                    <option value="after 6 months">After 6 months</option>
                    <option value="others">Others - specify date</option>
                  </select>
                  {startDate === "others" && (
                    <input
                      type="date"
                      className="form-control"
                      value={customStartDate}
                      onChange={(e) => setCustomStartDate(e.target.value)}
                      required
                    />
                  )}
                </td>
              </tr>

              <tr>
                <td>
                  <label className="form-label">
                    Is the plot registered under your name?
                  </label>
                </td>
                <td>
                  <div className="form-check-group">
                    <label className="form-check">
                      <input
                        type="radio"
                        name="plotRegistered"
                        value="Yes"
                        className="form-check-input"
                        onChange={(e) => setPlotRegistered(e.target.value)}
                        required
                      />
                      Yes
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="plotRegistered"
                        value="No"
                        className="form-check-input"
                        onChange={(e) => setPlotRegistered(e.target.value)}
                        required
                      />
                      No - registered under relative's name
                    </label>
                    <label className="form-check">
                      <input
                        type="radio"
                        name="plotRegistered"
                        value="NotBuy"
                        className="form-check-input"
                        onChange={(e) => setPlotRegistered(e.target.value)}
                        required
                      />
                      No - Yet to buy the plot
                    </label>
                  </div>
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="floorArea" className="form-label">
                    What is the floor area you are planning? (in sq.ft.)
                  </label>
                </td>
                <td>
                  <select
                    id="floorArea"
                    className="form-select"
                    value={floorArea}
                    onChange={(e) => setFloorArea(e.target.value)}
                    required
                  >
                    <option value="" disabled>
                      Select
                    </option>
                    <option value="More than 3000 sqft">
                      More than 3000 sqft
                    </option>
                    <option value="2000-3000 sqft">2000-3000 sqft</option>
                    <option value="1500-2000 sqft">1500-2000 sqft</option>
                    <option value="1000-1500 sqft">1000-1500 sqft</option>
                    <option value="less than 1000 sqft">
                      Less than 1000 sqft
                    </option>
                  </select>
                </td>
              </tr>

              <tr>
                <td>
                  <label htmlFor="profession" className="form-label">
                    Profession
                  </label>
                </td>
                <td>
                  <select
                    id="profession"
                    className="form-select"
                    value={profession}
                    onChange={(e) => setProfession(e.target.value)}
                    required
                  >
                    <option value="" disabled>
                      Select
                    </option>
                    <option value="business">Business</option>
                    <option value="service">Service</option>
                    <option value="government employee">
                      Government Employee
                    </option>
                    <option value="others">Others</option>
                  </select>
                  {profession === "others" && (
                    <input
                      type="text"
                      className="form-control"
                      placeholder="Enter profession"
                      value={customProfession}
                      onChange={(e) => setCustomProfession(e.target.value)}
                      required
                    />
                  )}
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
