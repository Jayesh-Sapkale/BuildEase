package com.construction.service;

import com.construction.dtos.CompanyDto;
import com.construction.updateDtos.UpdateCompanyDto;

public interface CompanyService {

	public CompanyDto addNewCompanyByBuilderId(CompanyDto companyDto,Integer builderId);

	public CompanyDto updateCompany(UpdateCompanyDto companyUpdateDto);

	
	



}
