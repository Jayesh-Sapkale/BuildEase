package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.CompanyDto;
import com.construction.entities.Company;
import com.construction.repositories.CompanyRepository;
import com.construction.service.CompanyService;
import com.construction.updateDtos.UpdateCompanyDto;

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
									
		CompanyDto savedCompanyDto = modelMapper.map(savedCompany, CompanyDto.class);
		
		savedCompanyDto.setBuilderName(companyDto.getBuilder().getBasicDetails().getFirstName() + " "
				+ companyDto.getBuilder().getBasicDetails().getLastName());

		savedCompanyDto.setCity(companyDto.getAddress().getCity());
		savedCompanyDto.setContactNumber(companyDto.getContactDetails().getContactNumber());// entity
		return savedCompanyDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public CompanyDto updateCompany(UpdateCompanyDto companyUpdateDto) {
		Company company = companyRepository.findById(companyUpdateDto.getId()).orElseThrow(
				() -> new EntityNotFoundException("Company not found with ID: " + companyUpdateDto.getId()));
		modelMapper.map(companyUpdateDto, company);
		Company updatedCompany = companyRepository.save(company);
		CompanyDto newUpdatedCompanyDto = modelMapper.map(updatedCompany, CompanyDto.class);
		
		newUpdatedCompanyDto.setBuilderName(updatedCompany.getBuilder().getBasicDetails().getFirstName()+" "+updatedCompany.getBuilder().getBasicDetails().getLastName());
		newUpdatedCompanyDto.setCity(updatedCompany.getAddress().getCity());
		newUpdatedCompanyDto.setContactNumber(updatedCompany.getContactDetails().getContactNumber());
		return newUpdatedCompanyDto;
	}

}
