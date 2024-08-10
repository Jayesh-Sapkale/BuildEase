import React from 'react';
import './CurrentProjects.css'; // Import the CSS for this component

const CurrentProjects = ({ projects, onProjectClick }) => {
  return (
    <div className="card">
      <h3>Current Projects</h3>
      <div className="row">
        {projects.map((project) => (
          <div key={project.id} className="col-md-4 mb-3">
            <div className="card h-100" onClick={() => onProjectClick(project)}>
              <img src={project.image} className="card-img-top" alt={project.name} />
              <div className="card-body">
                <h5 className="card-title">{project.name}</h5>
                <p className="card-text">{project.details}</p>
              </div>
            </div>
          </div>
        ))}
      </div>
    </div>
  );
};

export default CurrentProjects;
