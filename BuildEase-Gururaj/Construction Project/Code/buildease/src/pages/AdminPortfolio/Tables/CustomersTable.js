import React, { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import "../UpdateUser.css";

const CustomersTable = () => {
    const [customers, setCustomers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [editMode, setEditMode] = useState(false);
    const [selectedCustomer, setSelectedCustomer] = useState(null);
    const [formData, setFormData] = useState({
        name: "",
        contactNumber: "",
    });

    useEffect(() => {
        const fetchCustomers = async () => {
            try {
                const response = await axios.get("http://localhost:8081/admin/getAllCustomers");
                setCustomers(response.data);
            } catch (error) {
                setError(error.message || "An error occurred while fetching data.");
                toast.error("Failed to fetch customers. Please try again later.");
            } finally {
                setLoading(false);
            }
        };

        fetchCustomers();
    }, []);

    const handleEdit = (customer) => {
        setSelectedCustomer(customer);
        setFormData({
            name: customer.name || "",
            contactNumber: customer.contactNumber || "",
        });
        setEditMode(true);
    };

    const handleFormChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({ ...prevData, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        // Log form data before sending request
        console.log("Submitting form with data:", formData);

        try {
            console.log(formData)
            // PUT request to update the customer's details
            const response = await axios.put(
                `http://localhost:8081/customer/updateCustomerById/${selectedCustomer.id}`,
                formData
            );

            // Log response data
            console.log("Updated customer response:", response.data);

            // Update the customers list with the updated customer
            setCustomers((prevCustomers) =>
                prevCustomers.map((customer) =>
                    customer.id === selectedCustomer.id ? response.data : customer
                )
            );

            toast.success("Customer details updated successfully!");
            setEditMode(false);
            setSelectedCustomer(null);
        } catch (error) {
            console.error("Error updating customer:", error.message || "An error occurred.");
            toast.error("Failed to update customer. Please try again later.");
        }
    };

    const handleDelete = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            try {
                // DELETE request to delete the customer by ID
                await axios.delete(`http://localhost:8081/admin/deleteCustomerById/${id}`);

                // Remove the deleted customer from the state
                setCustomers((prevCustomers) =>
                    prevCustomers.filter((customer) => customer.id !== id)
                );

                toast.success("Customer deleted successfully.");
            } catch (error) {
                console.error("Error deleting customer:", error.message || "An error occurred.");
                toast.error("Failed to delete customer. Please try again later.");
            }
        }
    };

    const handleView = (id) => {
        console.log(`View button clicked for item with ID: ${id}`);
        toast.info(`View details for customer ID: ${id}`);
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="table-container">
            <ToastContainer />
            <section>
                <h2>List of Customers</h2>
                <div className="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Customer ID</th>
                                <th>Name</th>
                                <th>Contact Number</th>
                                <th>City</th>
                                <th>Account Creation Date</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {customers.length > 0 ? (
                                customers.map((customer) => (
                                    <tr key={customer.id}>
                                        <td>{customer.id}</td>
                                        <td>{customer.name}</td>
                                        <td>{customer.contactNumber}</td>
                                        <td>{customer.city}</td>
                                        <td>{new Date(customer.accountCreationDate).toLocaleDateString()}</td>
                                        <td>
                                            <div className="action-buttons">
                                                <button
                                                    className="button edit-btn"
                                                    onClick={() => handleEdit(customer)}
                                                >
                                                    Edit
                                                </button>
                                                <button
                                                    className="button delete-btn"
                                                    onClick={() => handleDelete(customer.id)}
                                                >
                                                    Delete
                                                </button>
                                                <button
                                                    className="button view-btn"
                                                    onClick={() => handleView(customer.id)}
                                                >
                                                    View
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="6">No customers available</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                </div>
            </section>

            {editMode && (
                <section className="update-form">
                    <h3>Edit Customer Details</h3>
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
                                setSelectedCustomer(null);
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

export default CustomersTable;
