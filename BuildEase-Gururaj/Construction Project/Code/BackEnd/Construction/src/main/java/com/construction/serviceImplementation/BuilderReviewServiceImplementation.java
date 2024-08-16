package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.BuilderReviewDto;
import com.construction.entities.Builder;
import com.construction.entities.BuilderReview;
import com.construction.entities.Customer;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.BuilderReviewRepository;
import com.construction.repositories.CustomerRepository;
import com.construction.service.BuilderReviewService;
import com.construction.updateDtos.UpdateBuilderReviewDto;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BuilderReviewServiceImplementation implements BuilderReviewService {

	@Autowired
	private BuilderReviewRepository builderReviewRepository;

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuilderReviewDto addNewBuilderReviewByCustomerAndBuilderId(BuilderReviewDto builderReviewDto,
			Integer customerId, Integer builderId) {

		Builder builder = builderRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with id " + builderId));
		BuilderReview builderReview = modelMapper.map(builderReviewDto, BuilderReview.class);
		Customer customer = customerRepository.findById(customerId)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with id " + customerId));
		builderReview.setBuilder(builder);
		builderReview.setCustomer(customer);;
		BuilderReview savedBuilderReview = builderReviewRepository.save(builderReview);

		BuilderReviewDto savedBuilderReviewDto = modelMapper.map(savedBuilderReview, BuilderReviewDto.class);

		savedBuilderReviewDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		savedBuilderReviewDto.setCustomerName(
				customer.getBasicDetails().getFirstName() + " " + customer.getBasicDetails().getLastName());

		return savedBuilderReviewDto;
	}

	@Override
	public BuilderReviewDto updateBuilderReview(UpdateBuilderReviewDto builderReviewUpdateDto) {
		BuilderReview builderReview = builderReviewRepository.findById(builderReviewUpdateDto.getId())
				.orElseThrow(() -> new EntityNotFoundException(
						"BuilderReview not found with ID: " + builderReviewUpdateDto.getId()));
		modelMapper.map(builderReviewUpdateDto, builderReview);
		BuilderReview updatedBuilderReview = builderReviewRepository.save(builderReview);

		BuilderReviewDto savedBuilderReviewDto = modelMapper.map(updatedBuilderReview, BuilderReviewDto.class);

		savedBuilderReviewDto.setCustomerName(updatedBuilderReview.getCustomer().getBasicDetails().getFirstName() + " "
				+ updatedBuilderReview.getCustomer().getBasicDetails().getLastName());
		savedBuilderReviewDto.setBuilderName(updatedBuilderReview.getBuilder().getBasicDetails().getFirstName() + " "
				+ updatedBuilderReview.getBuilder().getBasicDetails().getLastName());

		return savedBuilderReviewDto;
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
