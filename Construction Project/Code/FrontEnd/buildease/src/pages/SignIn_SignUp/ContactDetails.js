// ContactDetails.js
import React from "react";

const ContactDetails = ({ contactDetails, onChange, onBlur, errors }) => (
    <fieldset className="formGroup">
        <legend>Contact Details</legend>
        <input
            type="text"
            name="contactDetails.contactNumber"
            value={contactDetails.contactNumber}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Contact Number"
        />
        {errors.contactNumber && <div className="error">{errors.contactNumber}</div>}
        <input
            type="email"
            name="contactDetails.email"
            value={contactDetails.email}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Email"
        />
        {errors.email && <div className="error">{errors.email}</div>}
        <input
            type="text"
            name="contactDetails.url"
            value={contactDetails.url}
            onChange={onChange}
            onBlur={onBlur}
            placeholder="Website URL"
        />
    </fieldset>
);

export default ContactDetails;
