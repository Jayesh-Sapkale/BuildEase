package com.construction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.dtos.BuilderDto;
import com.construction.dtos.ProjectDto;
import com.construction.service.BuilderService;
import com.construction.updateDtos.UpdateBuilderDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value = "/builder")
public class BuilderController {

	@Autowired
	private BuilderService builderService;

	@PostMapping(value = "/signUp")
	@Operation(summary = "Add new builder", operationId = "addNewBuilder")
	public ResponseEntity<?> addNewBuilder(@RequestBody BuilderDto builderDto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(builderService.addNewBuilder(builderDto));
	}

	@PutMapping(value = "/updateBuilderById/{id}")
	@Operation(summary = "Update builder by id", operationId = "updateBuilderById")
	public ResponseEntity<?> updateBuilder(@PathVariable Integer id, @RequestBody UpdateBuilderDto updateBuilderDto) {
		updateBuilderDto.setId(id); // Set the ID to ensure we are updating the correct builder
		BuilderDto updatedBuilder = builderService.updateBuilder(updateBuilderDto);
		return ResponseEntity.ok(updatedBuilder);
	}

	@GetMapping(value = "/getPreviousProjects")
	@Operation(summary = "Get previous projects", operationId = "getPreviousProjects")
	public ResponseEntity<?> getPreviousProjects() {
		return ResponseEntity.ok(builderService.getPreviousProjects());
	}

	@GetMapping(value = "/getCurrentProjects")
	@Operation(summary = "Get current projects", operationId = "getCurrentProjects")
	public ResponseEntity<?> getCurrentProjects() {
		return ResponseEntity.ok(builderService.getCurrentProjects());
	}

	@PutMapping(value = "/updateProjectRequestStatusByBuilderId/{id}/{status}")
	@Operation(summary = "Update builder by id", operationId = "updateBuilderById")
	public ResponseEntity<?> updateProjectRequestStatusByBuilderId(@PathVariable boolean status,
			@PathVariable Integer id) {
		ProjectDto updatedProjectDto = builderService.updateProjectRequestStatusByBuilderId(id, status);
		return ResponseEntity.ok(updatedProjectDto);
	}
}
