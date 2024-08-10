// src/components/ProjectDetails.js
import React from 'react';
import './ProjectDetails.css';

const ProjectDetails = ({ project }) => {
  return (
    <div className="project-details-card">
      <h3>{project.name}</h3>
      <p>{project.details}</p>
    </div>
  );
};

export default ProjectDetails;
