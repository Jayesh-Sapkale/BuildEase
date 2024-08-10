import React from 'react';
import './UpdateProjects.css'; // Import the CSS for this component

const UpdateProjects = ({ projects, onProjectClick }) => {
  return (
    <div className="card">
      <h3>Update Existing Projects</h3>
      <ul className="list-group">
        {projects.map((project) => (
          <li key={project.id} className="list-group-item d-flex justify-content-between align-items-center">
            <img src={project.image} alt={project.name} className="img-thumbnail me-3" style={{ width: '100px', height: '100px' }} />
            <div>
              {project.name} - {project.rooms} rooms
              <div>{project.details}</div>
            </div>
            <div>
              <button className="btn btn-dark me-2">Update</button>
              <button className="btn btn-dark">Delete</button>
            </div>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default UpdateProjects;
