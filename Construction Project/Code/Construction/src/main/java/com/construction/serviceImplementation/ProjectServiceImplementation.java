package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.ProjectDto;
import com.construction.entities.Project;
import com.construction.repositories.ProjectRepository;
import com.construction.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDto addNewProject(ProjectDto projectDto) {

		projectDto.setBuilderName(projectDto.getBuilder().getBasicDetails().getFirstName() + " "
				+ projectDto.getBuilder().getBasicDetails().getLastName());
		projectDto.setCustomerName(projectDto.getCustomer().getBasicDetails().getFirstName() + " "
				+ projectDto.getCustomer().getBasicDetails().getLastName());
		projectDto.setConstructionType(projectDto.getConstructionDetails().getConstructionType().toString());
		projectDto.setCity(projectDto.getAddress().getCity());
		Project project = modelMapper.map(projectDto, Project.class);
		Project savedProject = projectRepository.save(project); // This persists the entity and returns the managed
																// entity
		
		ProjectDto savedProjectDto =modelMapper.map(savedProject, ProjectDto.class);
		savedProjectDto.setBuilderName(projectDto.getBuilder().getBasicDetails().getFirstName() + " "
				+ projectDto.getBuilder().getBasicDetails().getLastName());
		savedProjectDto.setCustomerName(projectDto.getCustomer().getBasicDetails().getFirstName() + " "
				+ projectDto.getCustomer().getBasicDetails().getLastName());
		savedProjectDto.setConstructionType(projectDto.getConstructionDetails().getConstructionType().toString());
		savedProjectDto.setCity(projectDto.getAddress().getCity());
		
		return savedProjectDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public ProjectDto updateProject(ProjectDto projectDto) {
		Project project = projectRepository.findById(projectDto.getProjectId()).orElseThrow(
				() -> new EntityNotFoundException("Project not found with ID: " + projectDto.getProjectId()));
		modelMapper.map(projectDto, project);
		Project updatedProject = projectRepository.save(project);
		ProjectDto savedProjectDto =modelMapper.map(updatedProject, ProjectDto.class);
		savedProjectDto.setBuilderName(projectDto.getBuilder().getBasicDetails().getFirstName() + " "
				+ projectDto.getBuilder().getBasicDetails().getLastName());
		savedProjectDto.setCustomerName(projectDto.getCustomer().getBasicDetails().getFirstName() + " "
				+ projectDto.getCustomer().getBasicDetails().getLastName());
		savedProjectDto.setConstructionType(projectDto.getConstructionDetails().getConstructionType().toString());
		savedProjectDto.setCity(projectDto.getAddress().getCity());
		return savedProjectDto;
	}

}
