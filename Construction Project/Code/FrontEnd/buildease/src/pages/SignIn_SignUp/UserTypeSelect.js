// UserTypeSelect.js
import React from "react";

const UserTypeSelect = ({ userType, onChange }) => (
    <div className="formGroup">
        <select
            name="userType"
            value={userType}
            onChange={onChange}
        >
            <option value="customer">Customer</option>
            <option value="builder">Builder</option>
        </select>
    </div>
);

export default UserTypeSelect;
