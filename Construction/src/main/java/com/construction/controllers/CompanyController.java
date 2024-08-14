package com.construction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.dtos.CompanyDto;
import com.construction.service.CompanyService;
import com.construction.updateDtos.UpdateCompanyDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping(value = "/addNewCompanyByBuilderId/{builderId}")
	@Operation(summary = "Add new company", operationId = "addNewCompanyByBuilderId")
	public ResponseEntity<?> addNewCompany(@RequestBody CompanyDto companyDto, @PathVariable Integer builderId) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(companyService.addNewCompanyByBuilderId(companyDto, builderId));
	}

	@PutMapping(value = "/updateCompanyById/{id}")
	@Operation(summary = "Update company by id", operationId = "updateCompanyById")
	public ResponseEntity<?> updateCompany(@PathVariable Integer id, @RequestBody UpdateCompanyDto companyUpdateDto) {
		companyUpdateDto.setId(id); // Set the ID to ensure we are updating the correct company

		CompanyDto updatedCompany = companyService.updateCompany(companyUpdateDto);
		return ResponseEntity.ok(updatedCompany);
	}
}
