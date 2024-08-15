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

import com.construction.dtos.ProjectDto;
import com.construction.service.ProjectService;
import com.construction.updateDtos.UpdateProjectDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping(value = "/addNewProject/{customerId}/{builderId}")
	@Operation(summary = "Add new project", operationId = "addNewProject")
	public ResponseEntity<?> addNewProject(@RequestBody ProjectDto projectDto, @PathVariable Integer customerId,
			@PathVariable Integer builderId) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(projectService.addNewProjectByCustomerAndBuilderId(projectDto, customerId, builderId));
	}

	@PutMapping(value = "/updateProjectByCustomerId/{id}")
	@Operation(summary = "Update project by customer id", operationId = "updateProjectByCustomerId")
	public ResponseEntity<?> updateProjectByCustomerId(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
		projectDto.setProjectId(id); // Set the ID to ensure we are updating the correct project
		ProjectDto updatedProject = projectService.updateProjectByCustomerId(projectDto, id);
		return ResponseEntity.ok(updatedProject);
	}

	@PutMapping(value = "/updateProjectByBuilderId/{id}")
	@Operation(summary = "Update project by builder id", operationId = "updateProjectByBuilderId")
	public ResponseEntity<?> updateProjectByBuilderId(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
		projectDto.setProjectId(id); // Set the ID to ensure we are updating the correct project
		ProjectDto updatedProject = projectService.updateProjectByBuilderId(projectDto, id);
		return ResponseEntity.ok(updatedProject);
	}

	@PutMapping(value = "/updateProjectByProjectId/{id}")
	@Operation(summary = "Update project by project id", operationId = "updateProjectByBuilderId")
	public ResponseEntity<?> updateProjectById(@PathVariable Integer id, @RequestBody UpdateProjectDto updateProjectDto) {
		System.out.println(updateProjectDto);
		updateProjectDto.setProjectId(id); // Set the ID to ensure we are updating the correct project
		ProjectDto updatedProject = projectService.updateProjectById(updateProjectDto, id);
		return ResponseEntity.ok(updatedProject);
	}
}
