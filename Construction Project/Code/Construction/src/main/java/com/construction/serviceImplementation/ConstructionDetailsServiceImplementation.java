package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.ConstructionDetailsDto;
import com.construction.entities.Builder;
import com.construction.entities.utils.ConstructionDetails;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.ConstructionDetailsRepository;
import com.construction.service.ConstructionDetailsService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ConstructionDetailsServiceImplementation implements ConstructionDetailsService {

	@Autowired
	private ConstructionDetailsRepository constructionDetailsRepository;

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConstructionDetailsDto addNewConstructionDetailByBuilderId(ConstructionDetailsDto constructionDetailsDto,
			Integer builderId) {

		Builder builder = builderRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with id " + builderId));
		ConstructionDetails constructionDetails = modelMapper.map(constructionDetailsDto, ConstructionDetails.class);
		constructionDetails.setBuilder(builder);
		ConstructionDetails savedConstructionDetails = constructionDetailsRepository.save(constructionDetails);

		ConstructionDetailsDto savedConstructionDetailsDto = modelMapper.map(savedConstructionDetails,
				ConstructionDetailsDto.class);

		savedConstructionDetailsDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		return savedConstructionDetailsDto;
	}

	@Override
	public ConstructionDetailsDto updateConstructionDetailsByBuilderId(ConstructionDetailsDto constructionDetailsDto,
			Integer builderId) {

		ConstructionDetails constructionDetails = constructionDetailsRepository.getByBuilderId(builderId).orElseThrow(
				() -> new EntityNotFoundException("Construction details not found for builder id " + builderId));

		modelMapper.map(constructionDetailsDto, constructionDetails);
		ConstructionDetails updatedConstructionDetails = constructionDetailsRepository.save(constructionDetails);

		ConstructionDetailsDto savedConstructionDetailsDto = modelMapper.map(updatedConstructionDetails,
				ConstructionDetailsDto.class);

		Builder builder = updatedConstructionDetails.getBuilder();

		savedConstructionDetailsDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		return savedConstructionDetailsDto;
	}

}
