import React, { useState } from 'react';
import './UserOld.css'; // Importing the CSS file
import Navbar from './Navbar';
import '@fortawesome/fontawesome-free/css/all.min.css';
import CreateProjectForm from './CreateProjectForm';
import Header from './Header'; // Adjust the path if needed
import Dropdown from './Dropdown'; // Import the new Dropdown component
import HeroSection from './HeroSection'; // Import the new HeroSection component
import image1 from '../assets/image1.jpg';
import image2 from '../assets/image2.jpg';

const User = () => {
  const [activeMenu, setActiveMenu] = useState('');
  const [sidenavOpen, setSidenavOpen] = useState(false);
  const [projects, setProjects] = useState([
    { id: 1, name: 'Project 1', rooms: 5, details: 'Details of Project 1', image: image1 },
    { id: 2, name: 'Project 2', rooms: 10, details: 'Details of Project 2', image: image2 },
  ]);
  const [selectedProject, setSelectedProject] = useState(null);
  const [dropdownOpen, setDropdownOpen] = useState(false);

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

  const toggleDropdown = () => {
    setDropdownOpen(!dropdownOpen);
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
        return (
          <div className="card">
            <h3>Create New Project</h3>
            <CreateProjectForm onCreate={handleCreateProject} />
          </div>
        );
      case 'update':
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
      case 'current':
        return (
          <div className="card">
            <h3>Current Projects</h3>
            <div className="row">
              {projects.map((project) => (
                <div key={project.id} className="col-md-4 mb-3">
                  <div className="card h-100" onClick={() => handleProjectClick(project)}>
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

      <HeroSection /> {/* Use the HeroSection component here */}

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

      {/* Add the dropdown component
      <Dropdown isOpen={dropdownOpen} toggleDropdown={toggleDropdown} /> */}
    </div>
  );
};

export default User;
