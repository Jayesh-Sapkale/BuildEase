package com.construction.service;

import com.construction.dtos.ProjectDto;
import com.construction.updateDtos.UpdateProjectDto;

public interface ProjectService {

	public ProjectDto addNewProjectByCustomerAndBuilderId(ProjectDto projectDto,Integer customerId,Integer builderId) ;

	public ProjectDto updateProjectByCustomerId(ProjectDto projectDto,Integer customerId);
	public ProjectDto updateProjectByBuilderId(ProjectDto projectDto,Integer builderId);
	public ProjectDto updateProjectById(UpdateProjectDto updateProjectDto,Integer id);
	



}
