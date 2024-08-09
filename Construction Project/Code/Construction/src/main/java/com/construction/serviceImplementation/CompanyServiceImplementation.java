package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.CompanyDto;
import com.construction.entities.Company;
import com.construction.repositories.CompanyRepository;
import com.construction.service.CompanyService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CompanyServiceImplementation implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CompanyDto addNewCompany(CompanyDto companyDto) {
		Company company = modelMapper.map(companyDto, Company.class);
		Company savedCompany = companyRepository.save(company); // This persists the entity and returns the managed
																	// entity
		return modelMapper.map(savedCompany, CompanyDto.class); // Convert the saved entity back to DTO and return
	}

	@Override
	public CompanyDto updateCompany(CompanyDto companyDto) {
		Company company = companyRepository.findById(companyDto.getCompanyId())
				.orElseThrow(() -> new EntityNotFoundException("Company not found with ID: " + companyDto.getCompanyId()));
		modelMapper.map(companyDto, company);
		Company updatedCompany = companyRepository.save(company);
		return modelMapper.map(updatedCompany, CompanyDto.class);
	}

	
	
	

}
