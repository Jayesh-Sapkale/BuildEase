package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.ProjectDto;
import com.construction.entities.Builder;
import com.construction.entities.Customer;
import com.construction.entities.Project;
import com.construction.entities.utils.ConstructionDetails;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.CustomerRepository;
import com.construction.repositories.ProjectRepository;
import com.construction.service.ProjectService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ProjectServiceImplementation implements ProjectService {

	@Autowired
	private ProjectRepository projectRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ProjectDto addNewProjectByCustomerAndBuilderId(ProjectDto projectDto, Integer customerId,
			Integer builderId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerId));
		Builder builder = builderRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with id " + builderId));

		Project project = modelMapper.map(projectDto, Project.class);
		project.setBuilder(builder);
		project.setCustomer(customer);
		projectRepository.save(project);

		ProjectDto savedProjectDto = modelMapper.map(project, ProjectDto.class);
		return savedProjectDto;
	}

	@Override
	public ProjectDto updateProjectByBuilderId(ProjectDto projectDto, Integer builderId) {

		Builder builder = builderRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + builderId));
		Project project = projectRepository.findByBuilderId(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + builderId));
		modelMapper.map(projectDto, project);
		ConstructionDetails constructionDetails = project.getConstructionDetails();
		Customer customer = project.getCustomer();
		project.setTotalPrice(builder.getRatePerMonth() * constructionDetails.getAreaInSqFt());
		Project updatedProject = projectRepository.save(project);
		System.out.println(constructionDetails);
		ProjectDto savedProjectDto = modelMapper.map(updatedProject, ProjectDto.class);
		savedProjectDto.setBuilderName(updatedProject.getBuilder().getBasicDetails().getFirstName() + " "
				+ customer.getBasicDetails().getLastName());

		savedProjectDto.setCustomerName(updatedProject.getCustomer().getBasicDetails().getFirstName() + " "
				+ updatedProject.getCustomer().getBasicDetails().getLastName());

		savedProjectDto.setConstructionType(constructionDetails.getConstructionType().toString());
		savedProjectDto.setCity(updatedProject.getAddress().getCity());
		return savedProjectDto;
	}

	@Override
	public ProjectDto updateProjectByCustomerId(ProjectDto projectDto, Integer customerId) {

		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerId));
		Project project = projectRepository.findByBuilderId(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + customerId));
		modelMapper.map(projectDto, project);
		ConstructionDetails constructionDetails = project.getConstructionDetails();
		Builder builder = constructionDetails.getBuilder();
		project.setTotalPrice(builder.getRatePerMonth() * constructionDetails.getAreaInSqFt());
		Project updatedProject = projectRepository.save(project);
		System.out.println(constructionDetails);
		ProjectDto savedProjectDto = modelMapper.map(updatedProject, ProjectDto.class);
		savedProjectDto.setBuilderName(updatedProject.getBuilder().getBasicDetails().getFirstName() + " "
				+ customer.getBasicDetails().getLastName());

		savedProjectDto.setCustomerName(updatedProject.getCustomer().getBasicDetails().getFirstName() + " "
				+ updatedProject.getCustomer().getBasicDetails().getLastName());

		savedProjectDto.setConstructionType(constructionDetails.getConstructionType().toString());
		savedProjectDto.setCity(updatedProject.getAddress().getCity());
		return savedProjectDto;
	}

}
