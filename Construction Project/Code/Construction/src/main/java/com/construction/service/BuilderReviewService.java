package com.construction.service;

import com.construction.dtos.BuilderReviewDto;

public interface BuilderReviewService {

	public BuilderReviewDto addNewBuilderReview(BuilderReviewDto builderReviewDto);

	public BuilderReviewDto updateBuilderReview(BuilderReviewDto builderReviewDto);

	public BuilderReviewDto setRatings(Integer builderId, BuilderReviewDto builderReviewDto);

}
