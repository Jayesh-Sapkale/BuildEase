package com.construction.service;

import com.construction.dtos.ProjectDto;

public interface ProjectService {

	public ProjectDto addNewProjectByCustomerAndBuilderId(ProjectDto projectDto,Integer customerId,Integer builderId) ;

	public ProjectDto updateProjectByCustomerId(ProjectDto projectDto,Integer customerId);
	public ProjectDto updateProjectByBuilderId(ProjectDto projectDto,Integer builderId);
	



}
