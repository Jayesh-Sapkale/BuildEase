import React from "react";
import CreateProjectForm from "./CreateProjectForm";
import "./CreateProject.css"; // Import the CSS for this component

const CreateProject = ({ onCreate }) => {
  return (
    <div className="container">
      <div className="card">
        <h3>Create New Project</h3>
        <CreateProjectForm onCreate={onCreate} />
      </div>
    </div>
  );
};

export default CreateProject;
