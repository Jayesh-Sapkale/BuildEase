package com.construction.service;

import com.construction.dtos.CompanyDto;
import com.construction.updateDtos.UpdateCompanyDto;

public interface CompanyService {

	public CompanyDto addNewCompany(CompanyDto companyDto);

	public CompanyDto updateCompany(UpdateCompanyDto companyUpdateDto);

	
	



}
