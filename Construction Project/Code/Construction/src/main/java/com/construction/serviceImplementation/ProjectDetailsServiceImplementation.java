package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.ProjectDetailsDto;
import com.construction.entities.Builder;
import com.construction.entities.Project;
import com.construction.entities.utils.ProjectDetails;
import com.construction.repositories.ProjectDetailsRepository;
import com.construction.repositories.ProjectRepository;
import com.construction.service.ProjectDetailsService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProjectDetailsServiceImplementation implements ProjectDetailsService {

	@Autowired
	private ProjectDetailsRepository constructionDetailsRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDetailsDto addNewConstructionDetailByProjectId(ProjectDetailsDto constructionDetailsDto,
			Integer projectId) {

		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with id " + projectId));
		ProjectDetails constructionDetails = modelMapper.map(constructionDetailsDto, ProjectDetails.class);
		Builder builder = project.getBuilder();

		ProjectDetails savedConstructionDetails = constructionDetailsRepository.save(constructionDetails);

		ProjectDetailsDto savedConstructionDetailsDto = modelMapper.map(savedConstructionDetails,
				ProjectDetailsDto.class);

		savedConstructionDetailsDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		return savedConstructionDetailsDto;
	}

	@Override
	public ProjectDetailsDto updateConstructionDetailsByProjectId(ProjectDetailsDto constructionDetailsDto,
			Integer projectId) {

		Project project = projectRepository.findById(projectId).orElseThrow(
				() -> new EntityNotFoundException("Construction details not found for builder id " + projectId));

		ProjectDetails projectDetails = project.getConstructionDetails();

		modelMapper.map(constructionDetailsDto, projectDetails);
		ProjectDetails updatedConstructionDetails = constructionDetailsRepository.save(projectDetails);

		ProjectDetailsDto savedConstructionDetailsDto = modelMapper.map(updatedConstructionDetails,
				ProjectDetailsDto.class);
		Builder builder = project.getBuilder();

		savedConstructionDetailsDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		return savedConstructionDetailsDto;
	}

}
