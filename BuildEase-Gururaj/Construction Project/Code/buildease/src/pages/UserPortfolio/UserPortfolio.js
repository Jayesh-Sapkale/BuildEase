import React, { useState } from "react";
import Header from "./Header";
import HeroSection from "./HeroSection";
import CreateProject from "./CreateProject";
import UpdateProjects from "./UpdateProjects";
import CurrentProjects from "./CurrentProject";
import SideMenu from "./SideMenu";
import WelcomeMessage from "./WelcomeMessage";
import "./UserPortfolio.css";

const User = () => {
  const [activeMenu, setActiveMenu] = useState("");
  const [sidenavOpen, setSidenavOpen] = useState(false);
  const [projects, setProjects] = useState([
    {
      id: 1,
      name: "Project 1",
      rooms: 5,
      details: "Details of Project 1",
      image: "path/to/image1.jpg",
    },
    {
      id: 2,
      name: "Project 2",
      rooms: 10,
      details: "Details of Project 2",
      image: "path/to/image2.jpg",
    },
  ]);
  const [selectedProject, setSelectedProject] = useState(null);

  const userName = "Mimansha";

  const handleMenuClick = (menu) => {
    setActiveMenu(menu);
    setSelectedProject(null);
    setSidenavOpen(false);
  };

  const handleCreateProject = (project) => {
    const newProject = { id: projects.length + 1, ...project };
    setProjects([...projects, newProject]);
  };

  const handleProjectClick = (project) => {
    setSelectedProject(project);
  };

  const renderContent = () => {
    if (selectedProject) {
      return (
        <div className="card">
          <h3>{selectedProject.name}</h3>
          <p>{selectedProject.details}</p>
        </div>
      );
    }

    switch (activeMenu) {
      case "create":
        return <CreateProject onCreate={handleCreateProject} />;
      case "update":
        return (
          <UpdateProjects
            projects={projects}
            onProjectClick={handleProjectClick}
          />
        );
      case "current":
        return (
          <CurrentProjects
            projects={projects}
            onProjectClick={handleProjectClick}
          />
        );
      default:
        return <WelcomeMessage />;
    }
  };

  return (
    <div className="user-page">
      <Header
        onMenuToggle={() => setSidenavOpen(!sidenavOpen)}
        userName={userName}
      />
      <div className="main-layout">
        <SideMenu
          sidenavOpen={sidenavOpen}
          onMenuClick={handleMenuClick}
          onClose={() => setSidenavOpen(false)}
        />
        <div className="main-content">
          <HeroSection />
          {renderContent()}
        </div>
      </div>
    </div>
  );
};

export default User;
