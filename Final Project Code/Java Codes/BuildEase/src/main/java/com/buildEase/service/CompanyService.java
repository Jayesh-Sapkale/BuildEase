package com.buildEase.service;

import java.util.List;

import com.buildEase.dtos.ApiResponse;
import com.buildEase.dtos.CompanyDto;

public interface CompanyService {

	public CompanyDto createCompany(CompanyDto companyDto);
	public List<CompanyDto> getAllCompanies();
	public CompanyDto getCompanyByBuilderId(Integer builderId);
	public CompanyDto getCompanyByCompanyId(Integer companyId);
	public CompanyDto updateCompanyDetails(CompanyDto companyDto);
	public ApiResponse removeCompanyByBuilderId(Integer builderId);

}
