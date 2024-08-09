package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.BuilderReviewDto;
import com.construction.entities.Builder;
import com.construction.entities.BuilderReview;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.BuilderReviewRepository;
import com.construction.service.BuilderReviewService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BuilderReviewServiceImplementation implements BuilderReviewService {

	@Autowired
	private BuilderReviewRepository builderReviewRepository;

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuilderReviewDto addNewBuilderReview(BuilderReviewDto builderReviewDto) {
		BuilderReview builderReview = modelMapper.map(builderReviewDto, BuilderReview.class);
		BuilderReview savedBuilderReview = builderReviewRepository.save(builderReview); // This persists the entity and
		// returns the managed entity
		return modelMapper.map(savedBuilderReview, BuilderReviewDto.class); // Convert the saved entity back to DTO and
																			// return
	}

	@Override
	public BuilderReviewDto updateBuilderReview(BuilderReviewDto builderReviewDto) {
		BuilderReview builderReview = builderReviewRepository.findById(builderReviewDto.getId()).orElseThrow(
				() -> new EntityNotFoundException("BuilderReview not found with ID: " + builderReviewDto.getId()));
		modelMapper.map(builderReviewDto, builderReview);
		BuilderReview updatedBuilderReview = builderReviewRepository.save(builderReview);
		return modelMapper.map(updatedBuilderReview, BuilderReviewDto.class);
	}

	@Override
	public BuilderReviewDto setRatings(Integer builderId, BuilderReviewDto builderReviewDto) {
		// Check if the builder exists
		builderRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + builderId));

		BuilderReview builderReview = modelMapper.map(builderReviewDto, BuilderReview.class);
		builderReview.setBuilder(new Builder(builderId)); // Assuming Builder has a constructor that accepts ID
		BuilderReview savedBuilderReview = builderReviewRepository.save(builderReview);
		return modelMapper.map(savedBuilderReview, BuilderReviewDto.class);
	}

}
