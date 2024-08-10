import React, { useState } from 'react';
import Navbar from '../pages/Navbar';
import Header from './Header';
import HeroSection from './HeroSection';
import CreateProject from './CreateProject';
import UpdateProjects from './UpdateProjects';
import CurrentProjects from './CurrentProjects';
import './User.css'; // Import the CSS file for User component


// import '@fortawesome/fontawesome-free/css/all.min.css';
// import image1 from '../assets/image1.jpg';
// import image2 from '../assets/image2.jpg';

const User = () => {
  const [activeMenu, setActiveMenu] = useState('');
  const [sidenavOpen, setSidenavOpen] = useState(false);
  const [projects, setProjects] = useState([
    { id: 1, name: 'Project 1', rooms: 5, details: 'Details of Project 1', image: 'path/to/image1.jpg' },
    { id: 2, name: 'Project 2', rooms: 10, details: 'Details of Project 2', image: 'path/to/image2.jpg' },
  ]);
  const [selectedProject, setSelectedProject] = useState(null);

  const userName = 'John Doe';

  const handleMenuClick = (menu) => {
    setActiveMenu(menu);
    setSelectedProject(null); // Deselect any selected project when changing the menu
    setSidenavOpen(false); // Close the sidenav after clicking a menu item
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
      case 'create':
        return <CreateProject onCreate={handleCreateProject} />;
      case 'update':
        return <UpdateProjects projects={projects} onProjectClick={handleProjectClick} />;
      case 'current':
        return <CurrentProjects projects={projects} onProjectClick={handleProjectClick} />;
      default:
        return <h2>Welcome</h2>;
    }
  };

  return (
    <div>
      {/* <Navbar 
        theme="user-theme" 
        title="User Dashboard" 
        customLinks={[
          { name: 'Home', href: '/' },
          { name: 'Projects', href: '/User' }
        ]} 
      /> */}

      <Header 
        onMenuToggle={() => setSidenavOpen(!sidenavOpen)}
        userName={userName} // Pass the userName prop
      />

      <HeroSection />

      <div className="container-fluid">
        <nav className={`sidenav ${sidenavOpen ? 'active' : ''}`}>
          <a href="#" onClick={() => handleMenuClick('create')} className="sidenav-link">Create Project</a>
          <a href="#" onClick={() => handleMenuClick('update')} className="sidenav-link">Update Project</a>
          <a href="#" onClick={() => handleMenuClick('current')} className="sidenav-link">Current Project</a>
          <div className="confirm-cancel-buttons">
            {/* <button className="confirm-btn" onClick={() => setSidenavOpen(false)}>Confirm</button> */}
            <button className="cancel-btn" onClick={() => setSidenavOpen(false)}>Cancel</button>
          </div>
        </nav>
        <div className="main-content">
          {renderContent()}
        </div>
      </div>
      <footer>
        <p>&copy; 2024 Construction Co. | <a href="#">Privacy Policy</a> | <a href="#">Terms of Service</a></p>
      </footer>
    </div>
  );
};

export default User;
