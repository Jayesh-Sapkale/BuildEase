package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.BuilderReviewDto;
import com.buildEase.entities.Builder;
import com.buildEase.entities.BuilderReview;
import com.buildEase.repositories.BuilderRepository;
import com.buildEase.repositories.BuilderReviewRepository;
import com.buildEase.service.BuilderReviewService;

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
    public BuilderReviewDto createBuilderReview(BuilderReviewDto builderReviewDto) {
        BuilderReview builderReview = modelMapper.map(builderReviewDto, BuilderReview.class);
        BuilderReview savedBuilderReview = builderReviewRepository.save(builderReview);
        return modelMapper.map(savedBuilderReview, BuilderReviewDto.class);
    }

    @Override
    public BuilderReviewDto getBuilderReviewById(Integer id) {
        BuilderReview builderReview = builderReviewRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("BuilderReview not found with ID: " + id));
        return modelMapper.map(builderReview, BuilderReviewDto.class);
    }

    @Override
    public List<BuilderReviewDto> getAllBuilderReviews() {
        List<BuilderReview> builderReviews = builderReviewRepository.findAll();
        return builderReviews.stream()
            .map(builderReview -> modelMapper.map(builderReview, BuilderReviewDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public BuilderReviewDto updateBuilderReview(BuilderReviewDto builderReviewDto) {
        BuilderReview existingBuilderReview = builderReviewRepository.findById(builderReviewDto.getReviewId())
            .orElseThrow(() -> new EntityNotFoundException("BuilderReview not found with ID: " + builderReviewDto.getReviewId()));
        modelMapper.map(builderReviewDto, existingBuilderReview);
        BuilderReview updatedBuilderReview = builderReviewRepository.save(existingBuilderReview);
        return modelMapper.map(updatedBuilderReview, BuilderReviewDto.class);
    }

    @Override
    public ApiResponse removeBuilderReview(Integer id) {
        if (!builderReviewRepository.existsById(id)) {
            throw new EntityNotFoundException("BuilderReview not found with ID: " + id);
        }
        builderReviewRepository.deleteById(id);
        return new ApiResponse("BuilderReview removed successfully");
    }

    @Override
    public ApiResponse removeAllBuilderReviews() {
        builderReviewRepository.deleteAll();
        return new ApiResponse("All BuilderReviews removed successfully");
    }

    @Override
    public BuilderReviewDto giveRatings(Integer builderId, BuilderReviewDto builderReviewDto) {
        // Check if the builder exists
        builderRepository.findById(builderId)
            .orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + builderId));

        BuilderReview builderReview = modelMapper.map(builderReviewDto, BuilderReview.class);
        builderReview.setBuilder(new Builder(builderId)); // Assuming Builder has a constructor that accepts ID
        BuilderReview savedBuilderReview = builderReviewRepository.save(builderReview);
        return modelMapper.map(savedBuilderReview, BuilderReviewDto.class);
    }

    @Override
    public Integer getRatings(Integer builderId) {
        Double averageRating = builderReviewRepository.getAverageRating(builderId);
        if (averageRating == null) {
            return 0; // No ratings available
        }
        return averageRating.intValue(); // Return as Integer
    }

}
