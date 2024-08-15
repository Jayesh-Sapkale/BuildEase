// BuilderDetails.js
import React from "react";

const BuilderDetails = ({ builderDetails, onChange, onBlur, errors }) => (
    <fieldset className="formGroup">
        <legend>Builder Details</legend>
        <input
            type="text"
            name="yearsOfExperience"
            value={builderDetails.yearsOfExperience}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Years of Experience"
        />
        {errors.yearsOfExperience && <div className="error">{errors.yearsOfExperience}</div>}
        <input
            type="text"
            name="ratePerMonth"
            value={builderDetails.ratePerMonth}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Rate per Month"
        />
        {errors.ratePerMonth && <div className="error">{errors.ratePerMonth}</div>}
        <input
            type="text"
            name="emergencyContactNumber"
            value={builderDetails.emergencyContactNumber}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Emergency Contact Number"
        />
        {errors.emergencyContactNumber && <div className="error">{errors.emergencyContactNumber}</div>}
        <select
            name="constructionType"
            value={builderDetails.constructionType}
            onChange={onChange}
        >
            <option value="WAREHOUSE">Warehouse</option>
            <option value="HOUSE">House</option>
            <option value="APARTMENT">Apartment</option>
            <option value="MALL">Mall</option>
        </select>
    </fieldset>
);

export default BuilderDetails;
