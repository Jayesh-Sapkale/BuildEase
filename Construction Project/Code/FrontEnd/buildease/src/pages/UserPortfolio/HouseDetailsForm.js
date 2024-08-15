import React, { useState } from "react";
import "./HouseDetailsForm.css";

function HouseDetailsForm() {
  const [formData, setFormData] = useState({
    houseName: "",
    ownerName: "",
    countryCode: "",
    mobileNumber: "",
    plotAddress: "",
    plotSize: "",
    numberOfFloors: "",
    totalFloorArea: "",
    houseType: "",
    numberOfBedrooms: "",
    numberOfBathrooms: "",
    numberOfLivingRooms: "",
    numberOfKitchens: "",
    roomDetails: "",
    houseStyle: "",
    heatingCoolingSystem: "",
    securitySystemDetails: "",
    emergencyExit: "",
    constructionTimelineFrom: "",
    constructionTimelineTo: "",
    paymentSchedule: "",
    buildingPermitDetails: "",
    specialRequirements: "",
    futureExpansionPlans: "",
  });

  const [errors, setErrors] = useState({});

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };

  const validate = () => {
    const newErrors = {};

    if (!formData.houseName) newErrors.houseName = "House Name is required.";
    if (!formData.ownerName) newErrors.ownerName = "Owner Name is required.";
    if (!formData.countryCode.match(/^\d{1,2}$/))
      newErrors.countryCode = "Country Code must be 1 or 2 digits.";
    if (!formData.mobileNumber.match(/^[1-9]\d{9}$/))
      newErrors.mobileNumber =
        "Mobile Number must be 10 digits starting from 1-9.";
    if (!formData.plotAddress)
      newErrors.plotAddress = "Plot Address is required.";
    if (!formData.plotSize || isNaN(formData.plotSize))
      newErrors.plotSize = "Plot Size must be a number.";
    if (!formData.numberOfFloors || isNaN(formData.numberOfFloors))
      newErrors.numberOfFloors = "Number of Floors must be a number.";
    if (!formData.totalFloorArea || isNaN(formData.totalFloorArea))
      newErrors.totalFloorArea = "Total Floor Area must be a number.";
    if (!formData.houseType) newErrors.houseType = "House Type is required.";
    if (!formData.numberOfBedrooms || isNaN(formData.numberOfBedrooms))
      newErrors.numberOfBedrooms = "Number of Bedrooms must be a number.";
    if (!formData.numberOfBathrooms || isNaN(formData.numberOfBathrooms))
      newErrors.numberOfBathrooms = "Number of Bathrooms must be a number.";
    if (!formData.numberOfLivingRooms || isNaN(formData.numberOfLivingRooms))
      newErrors.numberOfLivingRooms =
        "Number of Living Rooms must be a number.";
    if (!formData.numberOfKitchens || isNaN(formData.numberOfKitchens))
      newErrors.numberOfKitchens = "Number of Kitchens must be a number.";
    if (!formData.roomDetails)
      newErrors.roomDetails = "Details of the Room are required.";
    if (!formData.houseStyle) newErrors.houseStyle = "House Style is required.";
    if (!formData.heatingCoolingSystem)
      newErrors.heatingCoolingSystem =
        "Heating and Cooling System is required.";
    if (!formData.securitySystemDetails)
      newErrors.securitySystemDetails = "Security System Details are required.";
    if (!formData.emergencyExit || isNaN(formData.emergencyExit))
      newErrors.emergencyExit = "Emergency Exit must be a number.";
    if (!formData.constructionTimelineFrom || !formData.constructionTimelineTo)
      newErrors.constructionTimeline = "Construction Timeline is required.";
    if (!formData.paymentSchedule)
      newErrors.paymentSchedule = "Payment Schedule is required.";
    if (!formData.buildingPermitDetails)
      newErrors.buildingPermitDetails = "Building Permit Details are required.";
    if (!formData.specialRequirements)
      newErrors.specialRequirements = "Special Requirements are required.";
    if (!formData.futureExpansionPlans)
      newErrors.futureExpansionPlans = "Future Expansion Plans are required.";

    setErrors(newErrors);
    return Object.keys(newErrors).length === 0;
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    if (validate()) {
      console.log("Form Data:", formData);
      // Add form submission logic here
    }
  };

  return (
    <form onSubmit={handleSubmit} className="house-details-form">
      <table className="form-table">
        <tbody>
          <tr>
            <td>
              <label>House Name:</label>
            </td>
            <td>
              <input
                type="text"
                name="houseName"
                maxLength="50"
                value={formData.houseName}
                onChange={handleChange}
              />
              {errors.houseName && (
                <span className="error">{errors.houseName}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Owner Name:</label>
            </td>
            <td>
              <input
                type="text"
                name="ownerName"
                maxLength="50"
                value={formData.ownerName}
                onChange={handleChange}
              />
              {errors.ownerName && (
                <span className="error">{errors.ownerName}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Country Code:</label>
            </td>
            <td>
              <input
                type="text"
                name="countryCode"
                maxLength="2"
                pattern="\d{1,2}"
                value={formData.countryCode}
                onChange={handleChange}
              />
              {errors.countryCode && (
                <span className="error">{errors.countryCode}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Mobile Number:</label>
            </td>
            <td>
              <input
                type="text"
                name="mobileNumber"
                maxLength="10"
                pattern="[1-9]\d{9}"
                value={formData.mobileNumber}
                onChange={handleChange}
              />
              {errors.mobileNumber && (
                <span className="error">{errors.mobileNumber}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Plot Address:</label>
            </td>
            <td>
              <input
                type="text"
                name="plotAddress"
                maxLength="60"
                value={formData.plotAddress}
                onChange={handleChange}
              />
              {errors.plotAddress && (
                <span className="error">{errors.plotAddress}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Plot Size:</label>
            </td>
            <td>
              <input
                type="number"
                name="plotSize"
                value={formData.plotSize}
                onChange={handleChange}
              />
              {errors.plotSize && (
                <span className="error">{errors.plotSize}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Number of Floors:</label>
            </td>
            <td>
              <input
                type="number"
                name="numberOfFloors"
                value={formData.numberOfFloors}
                onChange={handleChange}
              />
              {errors.numberOfFloors && (
                <span className="error">{errors.numberOfFloors}</span>
              )}
            </td>
          </tr>

          {/* <tr>
            <td>
              <label>Total Floor Area:</label>
            </td>
            <td>
              <input
                type="range"
                name="totalFloorArea"
                min="500"
                max="5000"
                value={formData.totalFloorArea}
                onChange={handleChange}
              />
              {errors.totalFloorArea && (
                <span className="error">{errors.totalFloorArea}</span>
              )}
            </td>
          </tr> */}

          <tr>
            <td>
              <label>House Type:</label>
            </td>
            <td>
              <div className="radio-group">
                <label>
                  <input
                    type="radio"
                    name="houseType"
                    value="Bungalow"
                    checked={formData.houseType === "Bungalow"}
                    onChange={handleChange}
                  />
                  Bungalow
                </label>
                <label>
                  <input
                    type="radio"
                    name="houseType"
                    value="Apartment"
                    checked={formData.houseType === "Apartment"}
                    onChange={handleChange}
                  />
                  Apartment
                </label>
                <label>
                  <input
                    type="radio"
                    name="houseType"
                    value="Duplex"
                    checked={formData.houseType === "Duplex"}
                    onChange={handleChange}
                  />
                  Duplex
                </label>
                <label>
                  <input
                    type="radio"
                    name="houseType"
                    value="Villa"
                    checked={formData.houseType === "Villa"}
                    onChange={handleChange}
                  />
                  Villa
                </label>
              </div>
              {errors.houseType && (
                <span className="error">{errors.houseType}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Number of Bedrooms:</label>
            </td>
            <td>
              <input
                type="number"
                name="numberOfBedrooms"
                value={formData.numberOfBedrooms}
                onChange={handleChange}
              />
              {errors.numberOfBedrooms && (
                <span className="error">{errors.numberOfBedrooms}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Number of Bathrooms:</label>
            </td>
            <td>
              <input
                type="number"
                name="numberOfBathrooms"
                value={formData.numberOfBathrooms}
                onChange={handleChange}
              />
              {errors.numberOfBathrooms && (
                <span className="error">{errors.numberOfBathrooms}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Number of Living Rooms:</label>
            </td>
            <td>
              <input
                type="number"
                name="numberOfLivingRooms"
                value={formData.numberOfLivingRooms}
                onChange={handleChange}
              />
              {errors.numberOfLivingRooms && (
                <span className="error">{errors.numberOfLivingRooms}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Number of Kitchens:</label>
            </td>
            <td>
              <input
                type="number"
                name="numberOfKitchens"
                value={formData.numberOfKitchens}
                onChange={handleChange}
              />
              {errors.numberOfKitchens && (
                <span className="error">{errors.numberOfKitchens}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Room Details:</label>
            </td>
            <td>
              <textarea
                name="roomDetails"
                rows="3"
                value={formData.roomDetails}
                onChange={handleChange}
              />
              {errors.roomDetails && (
                <span className="error">{errors.roomDetails}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>House Style:</label>
            </td>
            <td>
              <select
                name="houseStyle"
                value={formData.houseStyle}
                onChange={handleChange}
              >
                <option value="">Select a style</option>
                <option value="Modern">Modern</option>
                <option value="Traditional">Traditional</option>
                <option value="Colonial">Colonial</option>
                <option value="Contemporary">Contemporary</option>
              </select>
              {errors.houseStyle && (
                <span className="error">{errors.houseStyle}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Heating/Cooling System:</label>
            </td>
            <td>
              <select
                name="heatingCoolingSystem"
                value={formData.heatingCoolingSystem}
                onChange={handleChange}
              >
                <option value="">Select a system</option>
                <option value="Central">Central</option>
                <option value="Radiant">Radiant</option>
                <option value="Split">Split</option>
                <option value="Geothermal">Geothermal</option>
              </select>
              {errors.heatingCoolingSystem && (
                <span className="error">{errors.heatingCoolingSystem}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Security System Details:</label>
            </td>
            <td>
              <textarea
                name="securitySystemDetails"
                rows="3"
                value={formData.securitySystemDetails}
                onChange={handleChange}
              />
              {errors.securitySystemDetails && (
                <span className="error">{errors.securitySystemDetails}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Emergency Exit:</label>
            </td>
            <td>
              <input
                type="number"
                name="emergencyExit"
                value={formData.emergencyExit}
                onChange={handleChange}
              />
              {errors.emergencyExit && (
                <span className="error">{errors.emergencyExit}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Construction Timeline:</label>
            </td>
            <td>
              <input
                type="date"
                name="constructionTimelineFrom"
                value={formData.constructionTimelineFrom}
                onChange={handleChange}
              />
              <input
                type="date"
                name="constructionTimelineTo"
                value={formData.constructionTimelineTo}
                onChange={handleChange}
              />
              {errors.constructionTimeline && (
                <span className="error">{errors.constructionTimeline}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Payment Schedule:</label>
            </td>
            <td>
              <input
                type="text"
                name="paymentSchedule"
                maxLength="60"
                value={formData.paymentSchedule}
                onChange={handleChange}
              />
              {errors.paymentSchedule && (
                <span className="error">{errors.paymentSchedule}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Building Permit Details:</label>
            </td>
            <td>
              <textarea
                name="buildingPermitDetails"
                rows="3"
                value={formData.buildingPermitDetails}
                onChange={handleChange}
              />
              {errors.buildingPermitDetails && (
                <span className="error">{errors.buildingPermitDetails}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Special Requirements:</label>
            </td>
            <td>
              <textarea
                name="specialRequirements"
                rows="3"
                value={formData.specialRequirements}
                onChange={handleChange}
              />
              {errors.specialRequirements && (
                <span className="error">{errors.specialRequirements}</span>
              )}
            </td>
          </tr>

          <tr>
            <td>
              <label>Future Expansion Plans:</label>
            </td>
            <td>
              <textarea
                name="futureExpansionPlans"
                rows="3"
                value={formData.futureExpansionPlans}
                onChange={handleChange}
              />
              {errors.futureExpansionPlans && (
                <span className="error">{errors.futureExpansionPlans}</span>
              )}
            </td>
          </tr>
        </tbody>
      </table>

      <button type="submit">Submit</button>
    </form>
  );
}

export default HouseDetailsForm;
