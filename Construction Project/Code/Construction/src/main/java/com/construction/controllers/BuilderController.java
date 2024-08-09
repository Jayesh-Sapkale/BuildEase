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

import com.construction.dtos.BuilderDto;
import com.construction.service.BuilderService;

@RestController
@RequestMapping("/builder")
public class BuilderController {

	@Autowired
	private BuilderService builderService;

	@PostMapping
	public ResponseEntity<?> addNewBuilder(@RequestBody BuilderDto builderDto) {
		System.out.println("In builder controller post request");
		System.out.println(builderDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(builderService.addNewBuilder(builderDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBuilder(@PathVariable Integer id, @RequestBody BuilderDto builderDto) {
		System.out.println("In builder controller put request");
		builderDto.setId(id); // Set the ID to ensure we are updating the correct builder
		BuilderDto updatedBuilder = builderService.updateBuilder(builderDto);
		return ResponseEntity.ok(updatedBuilder);
	}

}
