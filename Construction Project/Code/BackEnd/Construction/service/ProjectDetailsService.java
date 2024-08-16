package com.construction.service;

import com.construction.dtos.ProjectDetailsDto;

public interface ProjectDetailsService {

	public ProjectDetailsDto addNewConstructionDetailByProjectId(ProjectDetailsDto constructionDetailsDto,Integer projectId);

	public ProjectDetailsDto updateConstructionDetailsByProjectId(ProjectDetailsDto constructionDetailsDto,Integer projectId);


	
	

}
