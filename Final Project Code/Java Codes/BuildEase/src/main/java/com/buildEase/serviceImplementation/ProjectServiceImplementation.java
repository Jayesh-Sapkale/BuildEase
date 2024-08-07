package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.ProjectDto;
import com.buildEase.entities.Project;
import com.buildEase.repositories.ProjectRepository;
import com.buildEase.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	@Override
    public ProjectDto createProject(ProjectDto projectDto) {
        // Convert ProjectDto to Project entity
        Project project = modelMapper.map(projectDto, Project.class);
        // Save the Project entity to the database
        Project savedProject = projectRepository.save(project);
        // Convert the saved Project entity back to ProjectDto
        return modelMapper.map(savedProject, ProjectDto.class);
    }

    @Override
    public ProjectDto getProjectByProjectId(Integer projectId) {
        // Find the Project entity by its ID
        Project project = projectRepository.findById(projectId)
            .orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + projectId));
        // Convert the Project entity to ProjectDto
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getProjectsByBuilderId(Integer builderId) {
        // Find all Project entities by builder ID
        List<Project> projects = projectRepository.findProjectByBuilderId(builderId);
        // Convert the list of Project entities to a list of ProjectDto
        return projects.stream()
            .map(project -> modelMapper.map(project, ProjectDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public ProjectDto getProjectByUserId(Integer userId) {
        // Find the Project entity by user ID
        Project project = projectRepository.findProjectByUserId(userId)
            .orElseThrow(() -> new EntityNotFoundException("Project not found for user ID: " + userId));
        // Convert the Project entity to ProjectDto
        return modelMapper.map(project, ProjectDto.class);
    }

    @Override
    public List<ProjectDto> getAllProjects() {
        // Find all Project entities
        List<Project> projects = projectRepository.findAll();
        // Convert the list of Project entities to a list of ProjectDto
        return projects.stream()
            .map(project -> modelMapper.map(project, ProjectDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public ProjectDto updateProject(ProjectDto projectDto) {
        // Find the existing Project entity by its ID
        Project project = projectRepository.findById(projectDto.getProjectId())
            .orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + projectDto.getProjectId()));
        // Map the updated fields from ProjectDto to the existing Project entity
        modelMapper.map(projectDto, project);
        // Save the updated Project entity to the database
        Project updatedProject = projectRepository.save(project);
        // Convert the updated Project entity to ProjectDto
        return modelMapper.map(updatedProject, ProjectDto.class);
    }

    @Override
    public ApiResponse removeProject(Integer id) {
        // Check if the Project entity exists
        if (!projectRepository.existsById(id)) {
            throw new EntityNotFoundException("Project not found with ID: " + id);
        }
        // Delete the Project entity by its ID
        projectRepository.deleteById(id);
        // Return a success message
        return new ApiResponse("Project removed successfully");
    }

    @Override
    public ApiResponse removeAllProjects() {
        // Delete all Project entities
        projectRepository.deleteAll();
        // Return a success message
        return new ApiResponse("All projects removed successfully");
    }

}
