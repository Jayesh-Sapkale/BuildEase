import React, { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import "../UpdateUser.css";

const AdminsTable = () => {
    const [admins, setAdmins] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [editMode, setEditMode] = useState(false);
    const [selectedAdmin, setSelectedAdmin] = useState(null);
    const [formData, setFormData] = useState({
        name: "",
        contactNumber: "",
    });

    useEffect(() => {
        const fetchAdmins = async () => {
            try {
                const response = await axios.get("http://localhost:8081/admin/getAllAdmins");
                setAdmins(response.data);
            } catch (error) {
                setError(error.message || "An error occurred while fetching data.");
                toast.error("Failed to fetch admins. Please try again later.");
            } finally {
                setLoading(false);
            }
        };

        fetchAdmins();
    }, []);

    const handleEdit = (admin) => {
        setSelectedAdmin(admin);
        setFormData({
            name: admin.name || "",
            contactNumber: admin.contactNumber || "",

        });
        setEditMode(true);
    };

    const handleFormChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            // PUT request to update the admin's details
            const response = await axios.put(
                `http://localhost:8081/admin/updateAdminById/${selectedAdmin.id}`,
                formData
            );

            // Update the admins list with the updated admin
            setAdmins((prevAdmins) =>
                prevAdmins.map((admin) =>
                    admin.id === selectedAdmin.id ? response.data : admin
                )
            );

            // Show success message
            toast.success("Admin details updated successfully!");

            // Reset the form and edit mode
            setEditMode(false);
            setSelectedAdmin(null);
        } catch (error) {
            console.error("Error updating admin:", error.message || "An error occurred.");
            toast.error("Failed to update admin. Please try again later.");
        }
    };

    const handleDelete = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            try {
                // DELETE request to delete the admin by ID
                await axios.delete(`http://localhost:8081/admin/deleteAdminById/${id}`);

                // Remove the deleted admin from the state
                setAdmins((prevAdmins) =>
                    prevAdmins.filter((admin) => admin.id !== id)
                );

                // Show success message
                toast.success("Admin deleted successfully.");
            } catch (error) {
                console.error("Error deleting admin:", error.message || "An error occurred.");
                toast.error("Failed to delete admin. Please try again later.");
            }
        }
    };

    const handleView = (id) => {
        console.log(`View button clicked for item with ID: ${id}`);
        toast.info(`View details for admin ID: ${id}`);
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="table-container">
            <ToastContainer />
            <section>
                <h2>List of Admins</h2>
                <div className="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Admin ID</th>
                                <th>Name</th>
                                <th>Contact Number</th>

                                <th>City</th>
                                <th>Last Login</th>
                                <th>Last Password Change</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {admins.length > 0 ? (
                                admins.map((admin) => (
                                    <tr key={admin.id}>
                                        <td>{admin.id}</td>
                                        <td>{admin.name}</td>
                                        <td>{admin.contactNumber}</td>

                                        <td>{admin.city}</td>
                                        <td>{new Date(admin.lastLogin).toLocaleDateString()}</td>
                                        <td>{new Date(admin.lastPasswordChange).toLocaleDateString()}</td>
                                        <td>
                                            <div className="action-buttons">
                                                <button
                                                    className="button edit-btn"
                                                    onClick={() => handleEdit(admin)}
                                                >
                                                    Edit
                                                </button>
                                                <button
                                                    className="button delete-btn"
                                                    onClick={() => handleDelete(admin.id)}
                                                >
                                                    Delete
                                                </button>
                                                <button
                                                    className="button view-btn"
                                                    onClick={() => handleView(admin.id)}
                                                >
                                                    View
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="8">No admins available</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                </div>
            </section>

            {editMode && (
                <section className="update-form">
                    <h3>Edit Admin Details</h3>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label htmlFor="name">Name:</label>
                            <input
                                type="text"
                                id="name"
                                name="name"
                                value={formData.name}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label htmlFor="contactNumber">Contact Number:</label>
                            <input
                                type="text"
                                id="contactNumber"
                                name="contactNumber"
                                value={formData.contactNumber}
                                onChange={handleFormChange}
                                required
                                maxLength="10"
                                minLength="10"
                            />
                        </div>

                        <button type="submit">Save Changes</button>
                        <button
                            type="button"
                            onClick={() => {
                                setEditMode(false);
                                setSelectedAdmin(null);
                            }}
                        >
                            Cancel
                        </button>
                    </form>
                </section>
            )}
        </div>
    );
};

export default AdminsTable;

