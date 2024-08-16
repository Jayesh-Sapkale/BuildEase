import React, { useState, useEffect } from "react";
import "./UpdateUser.css"; // Import the CSS file

const UpdateUser = ({ userType, userId, onClose, onUpdate }) => {

    const capitalizeFirstLetter = (string) => {
        return string.charAt(0).toUpperCase() + string.slice(1).toLowerCase();
    };
    const [userDetails, setUserDetails] = useState({});
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        // Fetch user details based on userType and userId
        fetch(`http://localhost:8081/${userType}/get${userType.capitalizeFirstLetter}ById/${userId}`)
            .then((response) => response.json())
            .then((data) => {
                setUserDetails(data);
                setLoading(false);
            })
            .catch((error) => {
                console.error(`Error fetching ${userType} details:`, error);
                setLoading(false);
            });
    }, [userType, userId]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setUserDetails((prevDetails) => ({
            ...prevDetails,
            [name]: value,
        }));
    };
    const handleUpdate = () => {




        fetch(`http://localhost:8081/${userType}/update${userType.capitalizeFirstLetter}ById/${userId}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(userDetails),
        })
            .then((response) => response.json())
            .then((data) => {
                console.log(`${userType} updated successfully:`, data);
                if (onUpdate) {
                    onUpdate(data); // Notify the parent component about the update
                }
                if (onClose) {
                    onClose(); // Close the form after successful update
                }
            })
            .catch((error) => {
                console.error(`Error updating ${userType}:`, error);
            });
    };

    if (loading) {
        return <p>Loading...</p>;
    }

    return (
        <div className="update-form">
            <h2>Update {userType}</h2>
            <form>
                {userType === "Builder" && (
                    <>
                        <div>
                            <label>Name:</label>
                            <input
                                type="text"
                                name="name"
                                value={userDetails.name || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Years of Experience:</label>
                            <input
                                type="number"
                                name="yearsOfExperience"
                                value={userDetails.yearsOfExperience || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Rate per Month:</label>
                            <input
                                type="number"
                                name="ratePerMonth"
                                value={userDetails.ratePerMonth || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Availability:</label>
                            <input
                                type="text"
                                name="availability"
                                value={userDetails.availability || ""}
                                onChange={handleChange}
                            />
                        </div>
                        {/* Add more builder-specific fields */}
                    </>
                )}

                {userType === "Customer" && (
                    <>
                        <div>
                            <label>Name:</label>
                            <input
                                type="text"
                                name="name"
                                value={userDetails.name || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Email:</label>
                            <input
                                type="email"
                                name="email"
                                value={userDetails.email || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Contact Number:</label>
                            <input
                                type="text"
                                name="contactNumber"
                                value={userDetails.contactNumber || ""}
                                onChange={handleChange}
                            />
                        </div>
                        {/* Add more customer-specific fields */}
                    </>
                )}

                {userType === "Admin" && (
                    <>
                        <div>
                            <label>Name:</label>
                            <input
                                type="text"
                                name="name"
                                value={userDetails.name || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Role:</label>
                            <input
                                type="text"
                                name="role"
                                value={userDetails.role || ""}
                                onChange={handleChange}
                            />
                        </div>
                        <div>
                            <label>Last Login:</label>
                            <input
                                type="datetime-local"
                                name="lastLogin"
                                value={userDetails.lastLogin || ""}
                                onChange={handleChange}
                            />
                        </div>
                        {/* Add more admin-specific fields */}
                    </>
                )}

                <button type="button" onClick={handleUpdate}>
                    Update
                </button>
                <button type="button" onClick={onClose}>
                    Close
                </button>
            </form>
        </div>
    );
};

export default UpdateUser;
