package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.ConstructionDetailDto;
import com.buildEase.entities.ConstructionDetail;
import com.buildEase.repositories.ConstructionDetailRepository;
import com.buildEase.repositories.ProjectRepository;
import com.buildEase.service.ConstructionDetailService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class ConstructionDetailServiceImplementation implements ConstructionDetailService {

	@Autowired
	private ConstructionDetailRepository constructionDetailRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public ConstructionDetailDto createConstructionDetail(ConstructionDetailDto constructionDetailDto) {
		ConstructionDetail constructionDetail = modelMapper.map(constructionDetailDto, ConstructionDetail.class);
		ConstructionDetail savedConstructionDetail = constructionDetailRepository.save(constructionDetail);
		return modelMapper.map(savedConstructionDetail, ConstructionDetailDto.class);
	}

	@Override
	public ConstructionDetailDto getConstructionDetailById(Integer constructionId) {
		ConstructionDetail constructionDetail = constructionDetailRepository.findById(constructionId).orElseThrow(
				() -> new EntityNotFoundException("Construction detail not found with ID: " + constructionId));
		return modelMapper.map(constructionDetail, ConstructionDetailDto.class);
	}

	@Override
	public List<ConstructionDetailDto> getAllConstructionDetails() {
		List<ConstructionDetail> constructionDetails = constructionDetailRepository.findAll();
		return constructionDetails.stream().map(detail -> modelMapper.map(detail, ConstructionDetailDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public ConstructionDetailDto updateConstructionDetail(ConstructionDetailDto constructionDetailDto) {
		ConstructionDetail constructionDetail = constructionDetailRepository
				.findById(constructionDetailDto.getProjectDetailId()).orElseThrow(() -> new EntityNotFoundException(
						"Construction detail not found with ID: " + constructionDetailDto.getProjectDetailId()));
		modelMapper.map(constructionDetailDto, constructionDetail);
		ConstructionDetail updatedConstructionDetail = constructionDetailRepository.save(constructionDetail);
		return modelMapper.map(updatedConstructionDetail, ConstructionDetailDto.class);
	}

	@Override
	public ApiResponse removeConstructionDetail(Integer id) {
		if (!constructionDetailRepository.existsById(id)) {
			throw new EntityNotFoundException("Construction detail not found with ID: " + id);
		}
		constructionDetailRepository.deleteById(id);
		return new ApiResponse("Construction detail removed successfully");
	}

	@Override
	public ApiResponse removeAllConstructionDetails() {
		constructionDetailRepository.deleteAll();
		return new ApiResponse("All construction details removed successfully");
	}

}
