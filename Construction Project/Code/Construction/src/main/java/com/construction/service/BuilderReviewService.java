package com.construction.service;

import com.construction.dtos.BuilderReviewDto;
import com.construction.updateDtos.UpdateBuilderReviewDto;

public interface BuilderReviewService {

	public BuilderReviewDto addNewBuilderReview(BuilderReviewDto builderReviewDto);

	public BuilderReviewDto updateBuilderReview(UpdateBuilderReviewDto builderReviewUpdateDto);

	public BuilderReviewDto setRatings(Integer builderId, BuilderReviewDto builderReviewDto);

}
