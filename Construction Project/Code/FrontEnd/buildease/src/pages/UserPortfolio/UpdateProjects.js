import React from "react";
import "./UpdateProjects.css"; // Import the CSS for this component
import img1 from "../../assets/image1.jpeg";

const UpdateProjects = ({ projects, onProjectClick }) => {
  return (
    <div className="update-projects-container">
      <h3 className="update-projects-title">Update Existing Projects</h3>
      <ul className="update-projects-list">
        {projects.map((project) => (
          <li key={project.id} className="update-projects-item">
            <img
              // src={project.image}
              src={img1}
              alt={project.name}
              className="update-projects-image"
            />
            <div className="update-projects-details">
              <h4 className="project-name">{project.name}</h4>
              <p className="project-rooms">{project.rooms} rooms</p>
              <p className="project-description">{project.details}</p>
            </div>
            <div className="update-projects-actions">
              <button
                className="btn update-btn"
                onClick={() => onProjectClick("update", project.id)}
              >
                Update
              </button>
              <button
                className="btn delete-btn"
                onClick={() => onProjectClick("delete", project.id)}
              >
                Delete
              </button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UpdateProjects;
