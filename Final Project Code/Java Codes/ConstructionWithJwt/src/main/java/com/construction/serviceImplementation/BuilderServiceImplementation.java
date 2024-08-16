package com.construction.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.BuilderDto;
import com.construction.dtos.ProjectDto;
import com.construction.entities.Builder;
import com.construction.entities.Customer;
import com.construction.entities.Project;
import com.construction.enums.RequestStatus;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.ProjectRepository;
import com.construction.service.BuilderService;
import com.construction.updateDtos.UpdateBuilderDto;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BuilderServiceImplementation implements BuilderService {

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuilderDto addNewBuilder(BuilderDto builderDto) {

		Builder builder = modelMapper.map(builderDto, Builder.class);

		Builder savedBuilder = builderRepository.save(builder); // This persists the entity and returns the managed
		BuilderDto savedBuilderDto = modelMapper.map(savedBuilder, BuilderDto.class);
		savedBuilderDto.setCity(builderDto.getAddress().getCity());
		savedBuilderDto.setName(
				builderDto.getBasicDetails().getFirstName() + " " + builderDto.getBasicDetails().getLastName());
		savedBuilderDto.setContactNumber(builderDto.getContactDetails().getContactNumber());// entity
		return savedBuilderDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public BuilderDto updateBuilder(UpdateBuilderDto updateBuilderDto) {

		Integer id = updateBuilderDto.getId();
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		modelMapper.map(updateBuilderDto, builder);
		Builder updatedBuilder = builderRepository.save(builder);
		BuilderDto savedBuilderDto = modelMapper.map(updatedBuilder, BuilderDto.class);
		return savedBuilderDto;
	}

	@Override
	public List<ProjectDto> getPendingProjects() {

		// Retrieve all projects from the repository
		List<Project> projects = projectRepository.findAll();

		// Map the projects to ProjectDto and filter by status
		List<ProjectDto> previousProjects = projects.stream().map(pr -> {
			// Map individual Project to ProjectDto
			ProjectDto projectDto = modelMapper.map(pr, ProjectDto.class);
			projectDto.setBuilderName(pr.getBuilder().getBasicDetails().getFirstName() + " "
					+ pr.getBuilder().getBasicDetails().getLastName());
			projectDto.setCustomerName(pr.getCustomer().getBasicDetails().getFirstName() + " "
					+ pr.getCustomer().getBasicDetails().getLastName());
			projectDto.setCity(pr.getAddress().getCity());
			projectDto.setConstructionType(pr.getConstructionDetails().getConstructionType().toString());

			return projectDto;
		}).filter(p -> p.getRequestStatus().equals(RequestStatus.PENDING)) // Filter completed projects
				.collect(Collectors.toList()); // Collect the filtered list

		return previousProjects;
	}

	@Override
	public List<ProjectDto> getCurrentProjects() {

		// Retrieve all projects from the repository
		List<Project> projects = projectRepository.findAll();

		// Map the projects to ProjectDto and filter by status
		List<ProjectDto> previousProjects = projects.stream().map(pr -> {
			// Map individual Project to ProjectDto

			ProjectDto projectDto = modelMapper.map(pr, ProjectDto.class);
			projectDto.setBuilderName(pr.getBuilder().getBasicDetails().getFirstName() + " "
					+ pr.getBuilder().getBasicDetails().getLastName());
			projectDto.setCustomerName(pr.getCustomer().getBasicDetails().getFirstName() + " "
					+ pr.getCustomer().getBasicDetails().getLastName());
			projectDto.setCity(pr.getAddress().getCity());
			projectDto.setConstructionType(pr.getConstructionDetails().getConstructionType().toString());

			return projectDto;
		}).filter(p -> (p.getRequestStatus().equals(RequestStatus.ACCEPTED))) // Filter completed projects
				.collect(Collectors.toList()); // Collect the filtered list

		previousProjects.stream().forEach(p->System.out.println(p));
		return previousProjects;
	}

	@Override
	public ProjectDto updateProjectRequestStatusByBuilderId(Integer id, boolean status) {
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		RequestStatus request;

		Project project = projectRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Project not found with builder id " + id));

		if (!status)
			request = RequestStatus.REJECTED;
		else
			request = RequestStatus.ACCEPTED;

		project.setRequestStatus(request);
		Project updatedProject = projectRepository.save(project);

		Customer customer = updatedProject.getCustomer();

		ProjectDto savedProjectDto = modelMapper.map(updatedProject, ProjectDto.class);
		savedProjectDto.setRequestStatus(request);
		savedProjectDto.setCity(builder.getAddress().getCity());
		savedProjectDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		savedProjectDto.setCustomerName(
				customer.getBasicDetails().getFirstName() + " " + customer.getBasicDetails().getLastName());
		savedProjectDto.setConstructionType(savedProjectDto.getConstructionDetails().getConstructionType().toString());
		savedProjectDto.setRequestStatus(savedProjectDto.getRequestStatus());

		return savedProjectDto;
	}

}
