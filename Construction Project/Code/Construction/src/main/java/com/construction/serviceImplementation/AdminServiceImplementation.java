package com.construction.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.AdminDto;
import com.construction.dtos.ApiResponse;
import com.construction.dtos.BuilderDto;
import com.construction.dtos.BuilderReviewDto;
import com.construction.dtos.CompanyDto;
import com.construction.dtos.ConstructionDetailsDto;
import com.construction.dtos.CustomerDto;
import com.construction.dtos.ProjectDto;
import com.construction.entities.Admin;
import com.construction.entities.Builder;
import com.construction.entities.BuilderReview;
import com.construction.entities.Company;
import com.construction.entities.Customer;
import com.construction.entities.Project;
import com.construction.entities.utils.ConstructionDetails;
import com.construction.repositories.AdminRepository;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.BuilderReviewRepository;
import com.construction.repositories.CompanyRepository;
import com.construction.repositories.ConstructionDetailsRepository;
import com.construction.repositories.CustomerRepository;
import com.construction.repositories.ProjectRepository;
import com.construction.service.AdminService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class AdminServiceImplementation implements AdminService {

	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private BuilderReviewRepository builderReviewRepository;

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ConstructionDetailsRepository constructionDetailsRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public AdminDto addNewAdmin(AdminDto adminDto) {
		Admin admin = modelMapper.map(adminDto, Admin.class);
		Admin savedAdmin = adminRepository.save(admin); // This persists the entity and returns the managed entity
		return modelMapper.map(savedAdmin, AdminDto.class); // Convert the saved entity back to DTO and return
	}

	@Override
	public AdminDto getAdminById(Integer id) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));
		return modelMapper.map(admin, AdminDto.class);
	}

	@Override
	public List<AdminDto> getAllAdmins() {
		List<Admin> admins = adminRepository.findAll();
		return admins.stream().map(admin -> modelMapper.map(admin, AdminDto.class)).collect(Collectors.toList());
	}

	@Override
	public AdminDto updateAdmin(AdminDto adminDto) {
		Admin admin = adminRepository.findById(adminDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + adminDto.getId()));
		modelMapper.map(adminDto, admin);
		Admin updatedAdmin = adminRepository.save(admin);
		return modelMapper.map(updatedAdmin, AdminDto.class);
	}

	@Override
	public ApiResponse removeAdmin(Integer id) {
		if (!adminRepository.existsById(id)) {
			throw new EntityNotFoundException("Admin not found with ID: " + id); // replace this exception with our
																					// custom exceptions
		}
		adminRepository.deleteById(id);
		return new ApiResponse("Admin removed successfully");
	}

	@Override
	public ApiResponse removeAllAdmins() {
		adminRepository.deleteAll();
		return new ApiResponse("All admins removed successfully");
	}

	@Override
	public CustomerDto getCustomerById(Integer id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + id));
		return modelMapper.map(customer, CustomerDto.class);
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> modelMapper.map(customer, CustomerDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeCustomer(Integer id) {
		if (!customerRepository.existsById(id)) {
			throw new EntityNotFoundException("Customer not found with ID: " + id); // replace this exception with our
																					// custom exceptions
		}
		customerRepository.deleteById(id);
		return new ApiResponse("Customer removed successfully");
	}

	@Override
	public ApiResponse removeAllCustomers() {
		customerRepository.deleteAll();
		return new ApiResponse("All customers removed successfully");
	}

	@Override
	public BuilderDto getBuilderById(Integer id) {
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		return modelMapper.map(builder, BuilderDto.class);
	}

	@Override
	public List<BuilderDto> getAllBuilders() {
		List<Builder> builders = builderRepository.findAll();
		return builders.stream().map(builder -> modelMapper.map(builder, BuilderDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeBuilder(Integer id) {
		if (!builderRepository.existsById(id)) {
			throw new EntityNotFoundException("Builder not found with ID: " + id); // replace this exception with our
																					// custom exceptions
		}
		builderRepository.deleteById(id);
		return new ApiResponse("Builder removed successfully");
	}

	@Override
	public ApiResponse removeAllBuilders() {
		builderRepository.deleteAll();
		return new ApiResponse("All builders removed successfully");
	}

	@Override
	public BuilderReviewDto getBuilderReviewById(Integer id) {
		BuilderReview builderReview = builderReviewRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("BuilderReview not found with ID: " + id));
		return modelMapper.map(builderReview, BuilderReviewDto.class);
	}

	@Override
	public List<BuilderReviewDto> getAllBuilderReviews() {
		List<BuilderReview> builderReviews = builderReviewRepository.findAll();
		return builderReviews.stream().map(builderReview -> modelMapper.map(builderReview, BuilderReviewDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeBuilderReview(Integer id) {
		if (!builderReviewRepository.existsById(id)) {
			throw new EntityNotFoundException("BuilderReview not found with ID: " + id); // replace this exception with
																							// our custom exceptions
		}
		builderReviewRepository.deleteById(id);
		return new ApiResponse("BuilderReview removed successfully");
	}

	@Override
	public ApiResponse removeAllBuilderReviews() {
		builderReviewRepository.deleteAll();
		return new ApiResponse("All builderReviews removed successfully");
	}

	@Override
	public Integer getRatings(Integer builderId) {
		Double averageRating = builderReviewRepository.getAverageRating(builderId);
		if (averageRating == null) {
			return 0; // No ratings available
		}
		return averageRating.intValue(); // Return as Integer
	}

	@Override
	public CompanyDto getCompanyById(Integer id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		List<Company> companys = companyRepository.findAll();
		return companys.stream().map(company -> modelMapper.map(company, CompanyDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyDto getCompanyByBuilderId(Integer builderId) {
		Company company = companyRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with Builder ID: " + builderId));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public ApiResponse removeCompanyByBuilderId(Integer builderId) {
		if (!companyRepository.existsById(builderId)) {
			throw new EntityNotFoundException("Company not found with ID: " + builderId); // replace this exception with
			// our custom exceptions
		}
		companyRepository.deleteById(builderId);
		return new ApiResponse("Company removed successfully");
	}

	@Override
	public ApiResponse removeAllCompanies() {
		companyRepository.deleteAll();
		return new ApiResponse("All companies removed successfully");
	}

	@Override
	public ConstructionDetailsDto getConstructionDetailsById(Integer constructionId) {
		ConstructionDetails constructionDetails = constructionDetailsRepository.findById(constructionId).orElseThrow(
				() -> new EntityNotFoundException("Construction detail not found with ID: " + constructionId));
		return modelMapper.map(constructionDetails, ConstructionDetailsDto.class);
	}

	@Override
	public List<ConstructionDetailsDto> getAllConstructionDetails() {
		List<ConstructionDetails> constructionDetailss = constructionDetailsRepository.findAll();
		return constructionDetailss.stream().map(detail -> modelMapper.map(detail, ConstructionDetailsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeConstructionDetailsById(Integer id) {
		if (!constructionDetailsRepository.existsById(id)) {
			throw new EntityNotFoundException("Construction detail not found with ID: " + id);
		}
		constructionDetailsRepository.deleteById(id);
		return new ApiResponse("Construction detail removed successfully");
	}

	@Override
	public ApiResponse removeAllConstructionDetails() {
		constructionDetailsRepository.deleteAll();
		return new ApiResponse("All construction details removed successfully");
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
		return projects.stream().map(project -> modelMapper.map(project, ProjectDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ProjectDto getProjectByCustomerId(Integer userId) {
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
		return projects.stream().map(project -> modelMapper.map(project, ProjectDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeProjectById(Integer id) {
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
