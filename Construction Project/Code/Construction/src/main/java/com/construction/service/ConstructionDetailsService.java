package com.construction.service;

import com.construction.dtos.ConstructionDetailsDto;

public interface ConstructionDetailsService {

	public ConstructionDetailsDto addNewConstructionDetailByBuilderId(ConstructionDetailsDto constructionDetailsDto,Integer builderId);

	public ConstructionDetailsDto updateConstructionDetailsByBuilderId(ConstructionDetailsDto constructionDetailsDto,Integer builderId);


	
	

}
