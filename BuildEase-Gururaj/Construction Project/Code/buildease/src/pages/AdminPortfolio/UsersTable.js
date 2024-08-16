import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Make sure to install axios with `npm install axios`

const UsersTable = () => {
    const [users, setUsers] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const url = "http://localhost:8081";

    useEffect(() => {
        const fetchUsers = async () => {
            try {
                const response = await axios.get(url + '/admin/getAllCustomers'); // Adjust the endpoint as needed
                setUsers(response.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };

        fetchUsers();
    }, []);

    const handleEdit = (id) => {
        console.log(`Edit button clicked for item with ID: ${id}`);
    };

    const handleDelete = (id) => {
        console.log(`Delete button clicked for item with ID: ${id}`);
        if (window.confirm("Are you sure you want to delete this item?")) {
            console.log(`Item with ID: ${id} deleted.`);
        }
    };

    const handleView = (id) => {
        console.log(`View button clicked for item with ID: ${id}`);
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="table-container">
            <section>
                <h2>List of Users</h2>
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
                            {users.map(user => (
                                <tr key={user.customerId}>
                                    <td>
                                        <a href={`user${user.customerId}.html`}>
                                            {user.customerId}
                                        </a>
                                    </td>
                                    <td>{user.name}</td>
                                    <td>{user.contactNumber}</td>
                                    <td>{user.city}</td>
                                    <td>{user.accountCreationDate}</td>
                                    <td>
                                        <div className="action-buttons">
                                            <button
                                                className="button edit-btn"
                                                onClick={() => handleEdit(user.customerId)}
                                            >
                                                Edit
                                            </button>
                                            <button
                                                className="button delete-btn"
                                                onClick={() => handleDelete(user.customerId)}
                                            >
                                                Delete
                                            </button>
                                            <button
                                                className="button view-btn"
                                                onClick={() => handleView(user.customerId)}
                                            >
                                                View
                                            </button>
                                        </div>
                                    </td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    );
};

export default UsersTable;
