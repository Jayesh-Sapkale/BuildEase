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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @PostMapping
    @Operation(summary = "Add new company", operationId = "addNewCompany")
    public ResponseEntity<?> addNewCompany(@RequestBody CompanyDto companyDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(companyService.addNewCompany(companyDto));
    }

    @PutMapping(value="/{id}")
    @Operation(summary = "Update company by id", operationId = "updateCompanyById")
    public ResponseEntity<?> updateCompany(@PathVariable Integer id, @RequestBody CompanyDto companyDto) {
        companyDto.setCompanyId(id); // Set the ID to ensure we are updating the correct company
        CompanyDto updatedCompany = companyService.updateCompany(companyDto);
        return ResponseEntity.ok(updatedCompany);
    }
}
