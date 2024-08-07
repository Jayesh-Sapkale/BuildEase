package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.BuilderDto;
import com.buildEase.entities.Builder;
import com.buildEase.repositories.BuilderRepository;
import com.buildEase.service.BuilderService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class BuilderServiceImplementation implements BuilderService {

	@Autowired
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public BuilderDto createBuilder(BuilderDto builderDto) {
		Builder builder = modelMapper.map(builderDto, Builder.class);
		Builder savedBuilder = builderRepository.save(builder);
		return modelMapper.map(savedBuilder, BuilderDto.class);
	}

	@Override
	public BuilderDto getBuilderById(Integer id) {
		Builder builder = builderRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + id));
		return modelMapper.map(builder, BuilderDto.class);
	}

	@Override
	public List<BuilderDto> getAllBuilders() {
		List<Builder> builders = builderRepository.findAll();
		return builders.stream().map(builder -> modelMapper.map(builder, BuilderDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public BuilderDto updateBuilder(BuilderDto builderDto) {
		Builder builder = builderRepository.findById(builderDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Builder not found with ID: " + builderDto.getId()));
		modelMapper.map(builderDto, builder);
		Builder updatedBuilder = builderRepository.save(builder);
		return modelMapper.map(updatedBuilder, BuilderDto.class);
	}

	@Override
	public ApiResponse removeBuilder(Integer id) {
		if (!builderRepository.existsById(id)) {
			throw new EntityNotFoundException("Builder not found with ID: " + id);
		}
		builderRepository.deleteById(id);
		return new ApiResponse("Builder removed successfully");
	}

	@Override
	public ApiResponse removeAllBuilders() {
		builderRepository.deleteAll();
		return new ApiResponse("All builders removed successfully");
	}

}
