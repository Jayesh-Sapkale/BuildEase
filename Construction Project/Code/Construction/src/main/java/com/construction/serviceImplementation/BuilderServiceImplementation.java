package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.BuilderDto;
import com.construction.entities.Builder;
import com.construction.repositories.BuilderRepository;
import com.construction.service.BuilderService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BuilderServiceImplementation implements BuilderService {

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuilderDto addNewBuilder(BuilderDto builderDto) {
		Builder builder = modelMapper.map(builderDto, Builder.class);
		Builder savedBuilder = builderRepository.save(builder); // This persists the entity and returns the managed entity
		return modelMapper.map(savedBuilder, BuilderDto.class); // Convert the saved entity back to DTO and return
	}

	

	

	@Override
	public BuilderDto updateBuilder(BuilderDto builderDto) {
		Builder builder = builderRepository.findById(builderDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + builderDto.getId()));
		modelMapper.map(builderDto, builder);
		Builder updatedBuilder = builderRepository.save(builder);
		return modelMapper.map(updatedBuilder, BuilderDto.class);
	}

	

	

}
