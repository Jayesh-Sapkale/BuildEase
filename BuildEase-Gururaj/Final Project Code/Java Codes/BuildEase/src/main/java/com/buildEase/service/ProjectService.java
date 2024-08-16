package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.ProjectDto;

public interface ProjectService {
	
	public ProjectDto createProject(ProjectDto projectDto);
	public ProjectDto getProjectByProjectId(Integer projectId);
	public List<ProjectDto> getProjectsByBuilderId(Integer builderId);
	public ProjectDto getProjectByUserId(Integer userId);
	public List<ProjectDto> getAllProjects();
	public ProjectDto updateProject(ProjectDto projectDto);
	public ApiResponse removeProject(Integer id);
	public ApiResponse removeAllProjects();


}
