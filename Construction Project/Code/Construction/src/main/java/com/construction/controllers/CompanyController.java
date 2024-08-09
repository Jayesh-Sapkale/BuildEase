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

@RestController
@RequestMapping("/company")
public class CompanyController {

	@Autowired
	private CompanyService companyService;

	@PostMapping
	public ResponseEntity<?> addNewCompany(@RequestBody CompanyDto companyDto) {
		System.out.println("In company controller post request");
		System.out.println(companyDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addNewCompany(companyDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto) {
		System.out.println("In company controller put request");
		companyDto.setCompanyId(id); // Set the ID to ensure we are updating the correct company
		CompanyDto updatedCompany = companyService.updateCompany(companyDto);
		return ResponseEntity.ok(updatedCompany);
	}

}
