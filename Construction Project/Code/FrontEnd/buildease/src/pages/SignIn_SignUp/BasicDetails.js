// BasicDetails.js
import React from "react";

const BasicDetails = ({ basicDetails, onChange, onBlur, errors }) => (
    <fieldset className="formGroup">
        <legend>Basic Details</legend>
        <input
            type="text"
            name="basicDetails.firstName"
            value={basicDetails.firstName}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="First Name"
        />
        {errors.firstName && <div className="error">{errors.firstName}</div>}
        <input
            type="text"
            name="basicDetails.lastName"
            value={basicDetails.lastName}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Last Name"
        />
        {errors.lastName && <div className="error">{errors.lastName}</div>}
        <input
            type="date"
            name="basicDetails.birthDate"
            value={basicDetails.birthDate}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Date of Birth"
        />
        {errors.birthDate && <div className="error">{errors.birthDate}</div>}
        <select
            name="basicDetails.gender"
            value={basicDetails.gender}
            onChange={onChange}
            onBlur={onBlur}
        >
            <option value="">Select Gender</option>
            <option value="male">Male</option>
            <option value="female">Female</option>
            <option value="other">Other</option>
        </select>
        {errors.gender && <div className="error">{errors.gender}</div>}
    </fieldset>
);

export default BasicDetails;
