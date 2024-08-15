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
import com.construction.dtos.CustomerDto;
import com.construction.dtos.ProjectDetailsDto;
import com.construction.dtos.ProjectDto;
import com.construction.entities.Admin;
import com.construction.entities.Builder;
import com.construction.entities.BuilderReview;
import com.construction.entities.Company;
import com.construction.entities.Customer;
import com.construction.entities.Project;
import com.construction.entities.utils.ProjectDetails;
import com.construction.repositories.AdminRepository;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.BuilderReviewRepository;
import com.construction.repositories.CompanyRepository;
import com.construction.repositories.CustomerRepository;
import com.construction.repositories.ProjectDetailsRepository;
import com.construction.repositories.ProjectRepository;
import com.construction.service.AdminService;
import com.construction.updateDtos.UpdateAdminDto;

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
	private ProjectDetailsRepository constructionDetailsRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Autowired
	private ModelMapper modelMapper;

//	Admin Service

	@Override
	public AdminDto addNewAdmin(AdminDto adminDto) {

		Admin admin = modelMapper.map(adminDto, Admin.class);
		Admin savedAdmin = adminRepository.save(admin); // This persists the entity and returns the managed entity
		AdminDto savedAdminDto = modelMapper.map(savedAdmin, AdminDto.class);
		savedAdminDto.setCity(adminDto.getAddress().getCity());
		savedAdminDto
				.setName(adminDto.getBasicDetails().getFirstName() + " " + adminDto.getBasicDetails().getLastName());
		savedAdminDto.setContactNumber(adminDto.getContactDetails().getContactNumber());
		return savedAdminDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public AdminDto getAdminById(Integer id) {
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));

		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);
		adminDto.setCity(admin.getAddress().getCity());
		adminDto.setName(admin.getBasicDetails().getFirstName() + " " + admin.getBasicDetails().getLastName());
		adminDto.setContactNumber(admin.getContactDetails().getContactNumber());
		return adminDto;
	}

	@Override
	public List<AdminDto> getAllAdmins() {
		List<Admin> admins = adminRepository.findAll();
		return admins.stream().map(admin -> {
			AdminDto adminDto = modelMapper.map(admin, AdminDto.class);

			adminDto.setCity(admin.getAddress().getCity());
			adminDto.setName(admin.getBasicDetails().getFirstName() + " " + admin.getBasicDetails().getLastName());
			adminDto.setContactNumber(admin.getContactDetails().getContactNumber());
			return adminDto;
		}).collect(Collectors.toList());
	}

	@Override
	public AdminDto updateAdmin(UpdateAdminDto updateAdminDto) {
		
		Integer id = updateAdminDto.getId();
		Admin admin = adminRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found with ID: " + id));
		modelMapper.map(updateAdminDto, admin);
		Admin updatedAdmin = adminRepository.save(admin);
		AdminDto savedAdminDto = modelMapper.map(updatedAdmin, AdminDto.class);
		savedAdminDto.setCity(updatedAdmin.getAddress().getCity());
		savedAdminDto
				.setName(updateAdminDto.getName());
		savedAdminDto.setContactNumber(updateAdminDto.getContactNumber());
		return savedAdminDto;
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

//	Customer Service

	@Override
	public CustomerDto getCustomerById(Integer id) {
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + id));
		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

		customerDto.setName(customer.getBasicDetails().getFirstName() + " " + customer.getBasicDetails().getLastName());
		customerDto.setCity(customer.getAddress().getCity());
		customerDto.setContactNumber(customer.getContactDetails().getContactNumber());
		return customerDto;
	}

	@Override
	public List<CustomerDto> getAllCustomers() {
		List<Customer> customers = customerRepository.findAll();
		return customers.stream().map(customer -> {

			CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
			customerDto.setCity(customer.getAddress().getCity());
			customerDto.setName(
					customer.getBasicDetails().getFirstName() + " " + customer.getBasicDetails().getLastName());
			customerDto.setContactNumber(customer.getContactDetails().getContactNumber());
			return customerDto;
		}).collect(Collectors.toList());
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

//	Builder Service

	@Override
	public BuilderDto getBuilderById(Integer id) {
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		BuilderDto builderDto = modelMapper.map(builder, BuilderDto.class);
		builderDto.setCity(builder.getAddress().getCity());
		builderDto.setContactNumber(builder.getContactDetails().getContactNumber());
		builderDto.setName(builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		return builderDto;
	}

	@Override
	public List<BuilderDto> getAllBuilders() {
		List<Builder> builders = builderRepository.findAll();
		return builders.stream().map(builder -> {
			BuilderDto builderDto = modelMapper.map(builder, BuilderDto.class);
			builderDto.setCity(builder.getAddress().getCity());
			builderDto.setContactNumber(builder.getContactDetails().getContactNumber());
			builderDto
					.setName(builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
			return builderDto;
		}

		).collect(Collectors.toList());
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

//	BuilderReview Service

	@Override
	public BuilderReviewDto getBuilderReviewById(Integer id) {
		BuilderReview builderReview = builderReviewRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("BuilderReview not found with ID: " + id));
		
		Customer customer = builderReview.getCustomer();
		BuilderReviewDto builderReviewDto = modelMapper.map(builderReview, BuilderReviewDto.class);
		builderReviewDto.setCustomerName(customer.getBasicDetails().getFirstName() + " "
				+ customer.getBasicDetails().getLastName());
		builderReviewDto.setBuilderName(customer.getBasicDetails().getFirstName() + " "
				+ customer.getBasicDetails().getLastName());
		return builderReviewDto;
	}

	@Override
	public List<BuilderReviewDto> getAllBuilderReviews() {
		List<BuilderReview> builderReviews = builderReviewRepository.findAll();
		return builderReviews.stream().map(builderReview -> {
			// Map the basic properties
			BuilderReviewDto builderReviewDto = modelMapper.map(builderReview, BuilderReviewDto.class);

			// Set additional properties
			builderReviewDto.setBuilderName(builderReview.getBuilder().getBasicDetails().getFirstName() + " "
					+ builderReview.getBuilder().getBasicDetails().getLastName());
			builderReviewDto.setCustomerName(builderReview.getCustomer().getBasicDetails().getFirstName() + " "
					+ builderReview.getCustomer().getBasicDetails().getLastName());

			return builderReviewDto;
		}).collect(Collectors.toList());
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

//	Company Service

	@Override
	public CompanyDto getCompanyById(Integer id) {
		Company company = companyRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + id));

		CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

		companyDto.setBuilderName(company.getBuilder().getBasicDetails().getFirstName() + " "
				+ company.getBuilder().getBasicDetails().getLastName());
		companyDto.setCity(company.getAddress().getCity());
		companyDto.setContactNumber(company.getContactDetails().getContactNumber());
		return companyDto;
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		List<Company> companys = companyRepository.findAll();

		return companys.stream().map(company -> {
			CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

			companyDto.setBuilderName(company.getBuilder().getBasicDetails().getFirstName() + " "
					+ company.getBuilder().getBasicDetails().getLastName());
			companyDto.setCity(company.getAddress().getCity());
			companyDto.setContactNumber(company.getContactDetails().getContactNumber());

			return companyDto;
		}).collect(Collectors.toList());

	}

	@Override
	public CompanyDto getCompanyByBuilderId(Integer builderId) {
		Company company = companyRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with Builder ID: " + builderId));
		CompanyDto companyDto = modelMapper.map(company, CompanyDto.class);

		companyDto.setBuilderName(company.getBuilder().getBasicDetails().getFirstName() + " "
				+ company.getBuilder().getBasicDetails().getLastName());
		companyDto.setCity(company.getAddress().getCity());
		companyDto.setContactNumber(company.getContactDetails().getContactNumber());

		return companyDto;
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

//	Construction Service

	@Override
	public ProjectDetailsDto getConstructionDetailById(Integer constructionId) {
		ProjectDetails constructionDetails = constructionDetailsRepository.findById(constructionId).orElseThrow(
				() -> new EntityNotFoundException("Construction detail not found with ID: " + constructionId));
		return modelMapper.map(constructionDetails, ProjectDetailsDto.class);
	}

	@Override
	public List<ProjectDetailsDto> getAllConstructionDetails() {
		List<ProjectDetails> constructionDetailss = constructionDetailsRepository.findAll();
		return constructionDetailss.stream().map(detail -> modelMapper.map(detail, ProjectDetailsDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ApiResponse removeConstructionDetailById(Integer id) {
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

//	Project Service

	@Override
	public ProjectDto getProjectByProjectId(Integer projectId) {
		// Find the Project entity by its ID
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new EntityNotFoundException("Project not found with ID: " + projectId));
		// Convert the Project entity to ProjectDto

		ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

		projectDto.setBuilderName(project.getBuilder().getBasicDetails().getFirstName() + " "
				+ project.getBuilder().getBasicDetails().getLastName());
		projectDto.setCustomerName(project.getCustomer().getBasicDetails().getFirstName() + " "
				+ project.getCustomer().getBasicDetails().getLastName());
		projectDto.setCity(project.getAddress().getCity());
		projectDto.setConstructionType(project.getConstructionDetails().getConstructionType().toString());
		return projectDto;
	}

	@Override
	public List<ProjectDto> getProjectsByBuilderId(Integer builderId) {
		// Find all Project entities by builder ID
		List<Project> projects = projectRepository.findProjectByBuilderId(builderId);
		// Convert the list of Project entities to a list of ProjectDto
		return projects.stream().map(project -> {
			// Map the basic properties
			ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

			// Set additional properties
			projectDto.setBuilderName(project.getBuilder().getBasicDetails().getFirstName() + " "
					+ project.getBuilder().getBasicDetails().getLastName());
			projectDto.setCustomerName(project.getCustomer().getBasicDetails().getFirstName() + " "
					+ project.getCustomer().getBasicDetails().getLastName());
			projectDto.setConstructionType(project.getConstructionDetails().getConstructionType().toString()); // Assuming
																												// it's
																												// an
																												// enum
			projectDto.setCity(project.getAddress().getCity());

			return projectDto;
		}).collect(Collectors.toList());
	}

	@Override
	public ProjectDto getProjectByCustomerId(Integer userId) {
		// Find the Project entity by user ID
		Project project = projectRepository.findProjectByCustomerId(userId)
				.orElseThrow(() -> new EntityNotFoundException("Project not found for user ID: " + userId));
		// Convert the Project entity to ProjectDto
		ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

		projectDto.setBuilderName(project.getBuilder().getBasicDetails().getFirstName() + " "
				+ project.getBuilder().getBasicDetails().getLastName());
		projectDto.setCustomerName(project.getCustomer().getBasicDetails().getFirstName() + " "
				+ project.getCustomer().getBasicDetails().getLastName());
		projectDto.setCity(project.getAddress().getCity());
		projectDto.setConstructionType(project.getConstructionDetails().getConstructionType().toString());
		return projectDto;
	}

	@Override
	public List<ProjectDto> getAllProjects() {
		// Find all Project entities
		List<Project> projects = projectRepository.findAll();

		// Convert the list of Project entities to a list of ProjectDto
		return projects.stream().map(project -> {
			// Map the basic properties
			ProjectDto projectDto = modelMapper.map(project, ProjectDto.class);

			// Set additional properties
			projectDto.setBuilderName(project.getBuilder().getBasicDetails().getFirstName() + " "
					+ project.getBuilder().getBasicDetails().getLastName());
			projectDto.setCustomerName(project.getCustomer().getBasicDetails().getFirstName() + " "
					+ project.getCustomer().getBasicDetails().getLastName());
			projectDto.setConstructionType(project.getConstructionDetails().getConstructionType().toString()); // Assuming
																												// it's
																												// an
																												// enum
			projectDto.setCity(project.getAddress().getCity());

			return projectDto;
		}).collect(Collectors.toList());

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
