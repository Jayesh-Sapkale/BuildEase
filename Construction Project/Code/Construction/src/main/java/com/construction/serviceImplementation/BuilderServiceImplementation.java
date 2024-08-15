package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.BuilderDto;
import com.construction.entities.Builder;
import com.construction.repositories.BuilderRepository;
import com.construction.service.BuilderService;
import com.construction.updateDtos.UpdateBuilderDto;

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

		Builder savedBuilder = builderRepository.save(builder); // This persists the entity and returns the managed
		BuilderDto savedBuilderDto = modelMapper.map(savedBuilder, BuilderDto.class);
		savedBuilderDto.setCity(builderDto.getAddress().getCity());
		savedBuilderDto.setName(
				builderDto.getBasicDetails().getFirstName() + " " + builderDto.getBasicDetails().getLastName());
		savedBuilderDto.setContactNumber(builderDto.getContactDetails().getContactNumber());// entity
		return savedBuilderDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public BuilderDto updateBuilder(UpdateBuilderDto updateBuilderDto) {
		
		Integer id = updateBuilderDto.getId();
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		modelMapper.map(updateBuilderDto, builder);
		Builder updatedBuilder = builderRepository.save(builder);
		BuilderDto savedBuilderDto = modelMapper.map(updatedBuilder, BuilderDto.class);
		return savedBuilderDto;
	}

}
