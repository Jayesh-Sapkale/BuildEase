package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.ConstructionDetailsDto;
import com.construction.entities.utils.ConstructionDetails;
import com.construction.repositories.ConstructionDetailsRepository;
import com.construction.service.ConstructionDetailsService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ConstructionDetailsServiceImplementation implements ConstructionDetailsService {

	@Autowired
	private ConstructionDetailsRepository constructionDetailsRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConstructionDetailsDto addNewConstructionDetail(ConstructionDetailsDto constructionDetailsDto) {
		ConstructionDetails constructionDetails = modelMapper.map(constructionDetailsDto, ConstructionDetails.class);
		ConstructionDetails savedConstructionDetails = constructionDetailsRepository.save(constructionDetails);
		// entity
		return modelMapper.map(savedConstructionDetails, ConstructionDetailsDto.class); // Convert the saved entity back
																						// to DTO and return
	}

	@Override
	public ConstructionDetailsDto updateConstructionDetail(ConstructionDetailsDto constructionDetailsDto) {
		ConstructionDetails constructionDetails = constructionDetailsRepository
				.findById(constructionDetailsDto.getConstructionDetailId())
				.orElseThrow(() -> new EntityNotFoundException(
						"ConstructionDetails not found with ID: " + constructionDetailsDto.getConstructionDetailId()));
		modelMapper.map(constructionDetailsDto, constructionDetails);
		ConstructionDetails updatedConstructionDetails = constructionDetailsRepository.save(constructionDetails);
		return modelMapper.map(updatedConstructionDetails, ConstructionDetailsDto.class);
	}

}
