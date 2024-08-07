package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.ConstructionDetailDto;
import com.buildEase.entities.Project;

public interface ConstructionDetailService {
	
	public ConstructionDetailDto createConstructionDetail(ConstructionDetailDto constructionDetailDto);
	public ConstructionDetailDto getConstructionDetailById(Integer constructionId);
	public List<ConstructionDetailDto> getAllConstructionDetails();
	public ConstructionDetailDto updateConstructionDetail(ConstructionDetailDto constructionDetailDto);
	public ApiResponse removeConstructionDetail(Integer id);
	public ApiResponse removeAllConstructionDetails();

}
