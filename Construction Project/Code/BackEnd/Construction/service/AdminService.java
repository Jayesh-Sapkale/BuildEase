package com.construction.service;

import java.util.List;

import com.construction.dtos.AdminDto;
import com.construction.dtos.ApiResponse;
import com.construction.dtos.BuilderDto;
import com.construction.dtos.BuilderReviewDto;
import com.construction.dtos.CompanyDto;
import com.construction.dtos.CustomerDto;
import com.construction.dtos.ProjectDetailsDto;
import com.construction.dtos.ProjectDto;
import com.construction.updateDtos.UpdateAdminDto;

public interface AdminService {

	public AdminDto addNewAdmin(AdminDto adminDto);

	public AdminDto getAdminById(Integer id);

	public List<AdminDto> getAllAdmins();

	public AdminDto updateAdmin(UpdateAdminDto updateAdminDto);

	public ApiResponse removeAdmin(Integer id);

	public ApiResponse removeAllAdmins();

	public CustomerDto getCustomerById(Integer id);

	public List<CustomerDto> getAllCustomers();

	public ApiResponse removeCustomer(Integer id);

	public ApiResponse removeAllCustomers();

	public BuilderDto getBuilderById(Integer id);

	public List<BuilderDto> getAllBuilders();

	public ApiResponse removeBuilder(Integer id);

	public ApiResponse removeAllBuilders();

	public BuilderReviewDto getBuilderReviewById(Integer id);

	public List<BuilderReviewDto> getAllBuilderReviews();

	public ApiResponse removeBuilderReview(Integer id);

	public ApiResponse removeAllBuilderReviews();

	public Integer getRatings(Integer builderId);

	public CompanyDto getCompanyById(Integer id);

	public List<CompanyDto> getAllCompanies();

	public CompanyDto getCompanyByBuilderId(Integer builderId);

	public ApiResponse removeCompanyByBuilderId(Integer builderId);

	public ApiResponse removeAllCompanies();

	public ProjectDetailsDto getConstructionDetailById(Integer constructionId);

	public List<ProjectDetailsDto> getAllConstructionDetails();

	public ApiResponse removeConstructionDetailById(Integer id);

	public ApiResponse removeAllConstructionDetails();

	public ProjectDto getProjectByProjectId(Integer projectId);

	public List<ProjectDto> getProjectsByBuilderId(Integer builderId);

	public ProjectDto getProjectByCustomerId(Integer userId);

	public List<ProjectDto> getAllProjects();

	public ApiResponse removeProjectById(Integer id);

	public ApiResponse removeAllProjects();
}
