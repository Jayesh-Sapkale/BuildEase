package com.buildEase.serviceImplementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.CompanyDto;
import com.buildEase.entities.Company;
import com.buildEase.repositories.CompanyRepository;
import com.buildEase.service.CompanyService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CompanyDto createCompany(CompanyDto companyDto) {
		Company company = modelMapper.map(companyDto, Company.class);
		Company savedCompany = companyRepository.save(company);
		return modelMapper.map(savedCompany, CompanyDto.class);
	}

	@Override
	public List<CompanyDto> getAllCompanies() {
		List<Company> companies = companyRepository.findAll();
		return companies.stream().map(company -> modelMapper.map(company, CompanyDto.class))
				.collect(Collectors.toList());
	}

	@Override
	public CompanyDto getCompanyByBuilderId(Integer builderId) {
		Company company = companyRepository.findById(builderId)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with Builder ID: " + builderId));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public CompanyDto getCompanyByCompanyId(Integer companyId) {
		Company company = companyRepository.findById(companyId)
				.orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + companyId));
		return modelMapper.map(company, CompanyDto.class);
	}

	@Override
	public CompanyDto updateCompanyDetails(CompanyDto companyDto) {
		Company company = companyRepository.findById(companyDto.getCompanyId())
				.orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + companyDto.getCompanyId()));
		modelMapper.map(companyDto, company);
		Company updatedCompany = companyRepository.save(company);
		return modelMapper.map(updatedCompany, CompanyDto.class);
	}

	@Override
	public ApiResponse removeCompanyByBuilderId(Integer builderId) {
		 Company company = companyRepository.findCompanyByBuilderId(builderId)
                 .orElseThrow(() -> new EntityNotFoundException("Company not found with Builder ID: " + builderId));
companyRepository.delete(company);
return new ApiResponse("Company removed successfully");
	}

}
