package com.construction.service;

import java.util.List;

import com.construction.dtos.BuilderReviewDto;
import com.construction.updateDtos.UpdateBuilderReviewDto;

public interface BuilderReviewService {

	public BuilderReviewDto addNewBuilderReviewByCustomerAndBuilderId(BuilderReviewDto builderReviewDto,Integer customerId,Integer builderId);

	public BuilderReviewDto updateBuilderReview(UpdateBuilderReviewDto builderReviewUpdateDto);

	public BuilderReviewDto setRatings(Integer builderId, BuilderReviewDto builderReviewDto);
	
	public List<BuilderReviewDto> getBuilderReviewsByBuilderId(Integer builderId);

}
