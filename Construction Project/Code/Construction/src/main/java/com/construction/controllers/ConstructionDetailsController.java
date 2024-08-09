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

import com.construction.dtos.ConstructionDetailsDto;
import com.construction.service.ConstructionDetailsService;

@RestController
@RequestMapping("/constructionDetails")
public class ConstructionDetailsController {

	@Autowired
	private ConstructionDetailsService constructionDetailsService;

	@PostMapping
	public ResponseEntity<?> addNewConstructionDetails(@RequestBody ConstructionDetailsDto constructionDetailsDto) {
		System.out.println("In constructionDetails controller post request");
		System.out.println(constructionDetailsDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(constructionDetailsService.addNewConstructionDetails(constructionDetailsDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateConstructionDetails(@PathVariable Integer id,
			@RequestBody ConstructionDetailsDto constructionDetailsDto) {
		System.out.println("In constructionDetails controller put request");
		constructionDetailsDto.setConstructionDetailId(id); // Set the ID to ensure we are updating the correct constructionDetails
		ConstructionDetailsDto updatedConstructionDetails = constructionDetailsService
				.updateConstructionDetails(constructionDetailsDto);
		return ResponseEntity.ok(updatedConstructionDetails);
	}

}
