package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.BuilderReviewDto;

public interface BuilderReviewService {
	
	public BuilderReviewDto createBuilderReview(BuilderReviewDto builderReviewDto);
	public BuilderReviewDto getBuilderReviewById(Integer id);
	public List<BuilderReviewDto> getAllBuilderReviews();
	public BuilderReviewDto updateBuilderReview(BuilderReviewDto builderReviewDto);
	public ApiResponse removeBuilderReview(Integer id);
	public ApiResponse removeAllBuilderReviews();
	public BuilderReviewDto giveRatings(Integer builderId,BuilderReviewDto builderReviewDto);
	public Integer getRatings(Integer builderId);

}
