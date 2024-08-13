package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.CompanyDto;
import com.construction.entities.Builder;
import com.construction.entities.Company;
import com.construction.repositories.BuilderRepository;
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
	private BuilderRepository builderRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CompanyDto addNewCompanyByBuilderId(CompanyDto companyDto, Integer builderId) {

		Builder builder = builderRepository.findById(builderId).orElseThrow(()->new EntityNotFoundException("Builder not found with id "+builderId));
		Company company = modelMapper.map(companyDto, Company.class);
		company.setBuilder(builder);
		Company savedCompany = companyRepository.save(company);
		
		CompanyDto savedCompanyDto = modelMapper.map(savedCompany, CompanyDto.class);

		savedCompanyDto.setBuilderName(
				builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		savedCompanyDto.setCity(savedCompanyDto.getAddress().getCity());
		savedCompanyDto.setContactNumber(savedCompanyDto.getContactDetails().getContactNumber());

		return savedCompanyDto;
		
	}

	@Override
	public CompanyDto updateCompany(UpdateCompanyDto companyUpdateDto) {
		Company savedCompany = companyRepository.findById(companyUpdateDto.getId()).orElseThrow(
				() -> new EntityNotFoundException("Company not found with ID: " + companyUpdateDto.getId()));
		
		modelMapper.map(companyUpdateDto, savedCompany);
		Company updatedCompany = companyRepository.save(savedCompany);
		
		System.out.println(savedCompany);
		CompanyDto newUpdatedCompanyDto = modelMapper.map(updatedCompany, CompanyDto.class);

		newUpdatedCompanyDto.setBuilderName(updatedCompany.getBuilder().getBasicDetails().getFirstName() + " "
				+ updatedCompany.getBuilder().getBasicDetails().getLastName());
		newUpdatedCompanyDto.setCity(updatedCompany.getAddress().getCity());
		newUpdatedCompanyDto.setContactNumber(updatedCompany.getContactDetails().getContactNumber());
		return newUpdatedCompanyDto;
	}

}
