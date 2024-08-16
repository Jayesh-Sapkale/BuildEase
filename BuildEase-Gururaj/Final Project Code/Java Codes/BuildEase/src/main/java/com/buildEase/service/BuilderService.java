package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.BuilderDto;

public interface BuilderService {

	public BuilderDto createBuilder(BuilderDto builderDto);
	public BuilderDto getBuilderById(Integer id);
	public List<BuilderDto> getAllBuilders();
	public BuilderDto updateBuilder(BuilderDto builderDto);
	public ApiResponse removeBuilder(Integer id);
	public ApiResponse removeAllBuilders();

}
