// AddressDetails.js
import React from "react";

const AddressDetails = ({ address, onChange, onBlur, errors }) => (
    <fieldset className="formGroup">
        <legend>Address Details</legend>
        <input
            type="text"
            name="address.adrLine1"
            value={address.adrLine1}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Address Line 1"
        />
        {errors.adrLine1 && <div className="error">{errors.adrLine1}</div>}
        <input
            type="text"
            name="address.adrLine2"
            value={address.adrLine2}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Address Line 2"
        />
        <input
            type="text"
            name="address.city"
            value={address.city}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="City"
        />
        {errors.city && <div className="error">{errors.city}</div>}
        <input
            type="text"
            name="address.state"
            value={address.state}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="State"
        />
        {errors.state && <div className="error">{errors.state}</div>}
        <input
            type="text"
            name="address.country"
            value={address.country}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Country"
        />
        {errors.country && <div className="error">{errors.country}</div>}
        <input
            type="text"
            name="address.zipcode"
            value={address.zipcode}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Zipcode"
        />
        {errors.zipcode && <div className="error">{errors.zipcode}</div>}
    </fieldset>
);

export default AddressDetails;
