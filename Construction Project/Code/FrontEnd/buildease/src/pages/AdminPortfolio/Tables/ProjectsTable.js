import React, { useState, useEffect } from "react";
import axios from "axios";
import { ToastContainer, toast } from "react-toastify";
import 'react-toastify/dist/ReactToastify.css';
import "../UpdateUser.css";

const ProjectsTable = () => {
    const [projects, setProjects] = useState([]);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);
    const [editMode, setEditMode] = useState(false);
    const [selectedProject, setSelectedProject] = useState(null);
    const [formData, setFormData] = useState({
        projectName: "",
        constructionType: "",
        projectDescription: "",
        startDate: "",
        endDate: "",
    });

    useEffect(() => {
        const fetchProjects = async () => {
            try {
                const response = await axios.get("http://localhost:8081/admin/getAllProjects");
                setProjects(response.data);
            } catch (error) {
                setError(error.message || "An error occurred while fetching data.");
                toast.error("Failed to fetch projects. Please try again later.");
            } finally {
                setLoading(false);
            }
        };

        fetchProjects();
    }, []);

    const handleEdit = (project) => {
        setSelectedProject(project);
        setFormData({
            projectName: project.projectName || "",
            constructionType: project.constructionType || "",
            projectDescription: project.projectDescription || "",
            startDate: project.startDate || "",
            endDate: project.endDate || "",
        });
        setEditMode(true);
    };

    const handleFormChange = (e) => {
        const { name, value } = e.target;
        setFormData((prevData) => ({
            ...prevData,
            [name]: value,
        }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();

        try {
            if (!selectedProject || !selectedProject.projectId) {
                throw new Error("Invalid project selection");
            }

            // PUT request to update the project's details
            const response = await axios.put(
                `http://localhost:8081/project/updateProjectByProjectId/${selectedProject.projectId}`,
                formData
            );

            // Update the projects list with the updated project
            setProjects((prevProjects) =>
                prevProjects.map((project) =>
                    project.projectId === selectedProject.projectId ? response.data : project
                )
            );

            // Show success message
            toast.success("Project details updated successfully!");

            // Reset the form and edit mode
            setEditMode(false);
            setSelectedProject(null);
        } catch (error) {
            console.error("Error updating project:", error.message || "An error occurred.");
            toast.error("Failed to update project. Please try again later.");
        }
    };

    const handleDelete = async (id) => {
        if (window.confirm("Are you sure you want to delete this item?")) {
            try {
                await axios.delete(`http://localhost:8081/admin/deleteProjectById/${id}`);
                setProjects((prevProjects) =>
                    prevProjects.filter((project) => project.projectId !== id)
                );
                toast.success("Project deleted successfully.");
            } catch (error) {
                console.error("Error deleting project:", error.message || "An error occurred.");
                toast.error("Failed to delete project. Please try again later.");
            }
        }
    };

    const handleView = (id) => {
        console.log(`View button clicked for item with ID: ${id}`);
        toast.info(`View details for project ID: ${id}`);
    };

    if (loading) return <p>Loading...</p>;
    if (error) return <p>Error: {error}</p>;

    return (
        <div className="table-container">
            <ToastContainer />
            <section>
                <h2>List of Projects</h2>
                <div className="table-wrapper">
                    <table>
                        <thead>
                            <tr>
                                <th>Project ID</th>
                                <th>Project Name</th>
                                <th>Construction Type</th>
                                <th>City</th>
                                <th>Start Date</th>
                                <th>End Date</th>

                                <th>Description</th>
                                <th>Total Price</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            {projects.length > 0 ? (
                                projects.map((project) => (
                                    <tr key={project.projectId}>
                                        <td>{project.projectId}</td>
                                        <td>{project.projectName}</td>
                                        <td>{project.constructionType}</td>
                                        <td>{project.city}</td>
                                        <td>{new Date(project.startDate).toLocaleDateString()}</td>
                                        <td>{new Date(project.endDate).toLocaleDateString()}</td>

                                        <td>{project.projectDescription}</td>
                                        <td>{project.totalPrice.toFixed(2)}</td>
                                        <td>
                                            <div className="action-buttons">
                                                <button
                                                    className="button edit-btn"
                                                    onClick={() => handleEdit(project)}
                                                >
                                                    Edit
                                                </button>
                                                <button
                                                    className="button delete-btn"
                                                    onClick={() => handleDelete(project.projectId)}
                                                >
                                                    Delete
                                                </button>
                                                <button
                                                    className="button view-btn"
                                                    onClick={() => handleView(project.projectId)}
                                                >
                                                    View
                                                </button>
                                            </div>
                                        </td>
                                    </tr>
                                ))
                            ) : (
                                <tr>
                                    <td colSpan="10">No projects available</td>
                                </tr>
                            )}
                        </tbody>
                    </table>
                </div>
            </section>

            {editMode && (
                <section className="update-form">
                    <h3>Edit Project Details</h3>
                    <form onSubmit={handleSubmit}>
                        <div>
                            <label htmlFor="projectName">Project Name:</label>
                            <input
                                type="text"
                                id="projectName"
                                name="projectName"
                                value={formData.projectName}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label htmlFor="constructionType">Construction Type:</label>
                            <select
                                id="constructionType"
                                name="constructionType"
                                value={formData.constructionType}
                                onChange={handleFormChange}
                                required
                            >
                                <option value="WAREHOUSE">Warehouse</option>
                                <option value="HOUSE">House</option>
                                <option value="APARTMENT">Apartment</option>
                                <option value="MALL">Mall</option>
                            </select>
                        </div>
                        <div>
                            <label htmlFor="projectDescription">Description:</label>
                            <textarea
                                id="projectDescription"
                                name="projectDescription"
                                value={formData.projectDescription}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label htmlFor="startDate">Start Date:</label>
                            <input
                                type="date"
                                id="startDate"
                                name="startDate"
                                value={formData.startDate}
                                onChange={handleFormChange}
                                required
                            />
                        </div>
                        <div>
                            <label htmlFor="endDate">End Date:</label>
                            <input
                                type="date"
                                id="endDate"
                                name="endDate"
                                value={formData.endDate}
                                onChange={handleFormChange}
                                required
                            />
                        </div>

                        <button type="submit">Save Changes</button>
                        <button
                            type="button"
                            onClick={() => {
                                setEditMode(false);
                                setSelectedProject(null);
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

export default ProjectsTable;
