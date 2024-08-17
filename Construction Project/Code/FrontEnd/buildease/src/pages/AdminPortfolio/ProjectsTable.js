import React, { useState, useEffect } from 'react';
import axios from 'axios'; // Make sure to install axios with `npm install axios`

const ProjectsTable = () => {
    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    const url = "http://localhost:8081";

    useEffect(() => {
        const fetchProjects = async () => {
            try {
                const response = await axios.get(url + '/admin/getAllProjects'); // Adjust the endpoint as needed
                setProjects(response.data);
            } catch (error) {
                setError(error.message);
            } finally {
                setLoading(false);
            }
        };

        fetchProjects();
    }, []);

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="table-container">
            <section>
                <h2>Project Table</h2>
                <div className="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Project ID</th>
                                <th>Project Name</th>

                                <th>Start Date</th>
                                <th>End Date</th>
                                <th>Total Price</th>
                                <th>City</th>
                                <th>Builder Name</th>
                                <th>Customer Name</th>
                            </tr>
                        </thead>
                        <tbody>
                            {projects.map(project => (
                                <tr key={project.projectId}>
                                    <td>{project.projectId}</td>
                                    <td>{project.projectName}</td>

                                    <td>{project.startDate}</td>
                                    <td>{project.endDate}</td>
                                    <td>{project.totalPrice}</td>
                                    <td>{project.city}</td>
                                    <td>{project.builderName}</td>
                                    <td>{project.customerName}</td>
                                </tr>
                            ))}
                        </tbody>
                    </table>
                </div>
            </section>
        </div>
    );
};

export default ProjectsTable;
