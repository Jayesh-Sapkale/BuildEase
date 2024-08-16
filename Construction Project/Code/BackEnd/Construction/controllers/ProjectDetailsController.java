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

import com.construction.dtos.ProjectDetailsDto;
import com.construction.service.ProjectDetailsService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/constructionDetails")
public class ProjectDetailsController {

	@Autowired
	private ProjectDetailsService constructionDetailsService;

	@PostMapping(value = "addNewConstructionDetailByProjectId/{projectId}")
	@Operation(summary = "Add new construction detail", operationId = "addNewConstructionDetailByBuilderId")
	public ResponseEntity<?> addNewConstructionDetailsByBuilderId(@RequestBody ProjectDetailsDto constructionDetailsDto, @PathVariable Integer projectId) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(constructionDetailsService.addNewConstructionDetailByProjectId(constructionDetailsDto,projectId));
	}

	@PutMapping(value = "/updateConstructionDetailById/{id}")
	@Operation(summary = "Update construction detail by id", operationId = "updateConstructionDetailById")
	public ResponseEntity<?> updateConstructionDetail(@PathVariable Integer id,
			@RequestBody ProjectDetailsDto constructionDetailsDto) {
		
		ProjectDetailsDto updatedConstructionDetails = constructionDetailsService
				.updateConstructionDetailsByProjectId(constructionDetailsDto,id);
		return ResponseEntity.ok(updatedConstructionDetails);
	}
}
