package com.construction.service;

import java.util.List;

import com.construction.dtos.BuilderDto;
import com.construction.dtos.ProjectDto;
import com.construction.updateDtos.UpdateBuilderDto;

public interface BuilderService {

	public BuilderDto addNewBuilder(BuilderDto builderDto);

	public BuilderDto updateBuilder(UpdateBuilderDto updateBuilderDto);

	public List<ProjectDto> getPreviousProjects();

	public List<ProjectDto> getCurrentProjects();

	public ProjectDto updateProjectRequestStatusByBuilderId(Integer id, boolean status);

}
