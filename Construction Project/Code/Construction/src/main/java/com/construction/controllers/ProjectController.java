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

@RestController
@RequestMapping("/project")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@PostMapping
	public ResponseEntity<?> addNewProject(@RequestBody ProjectDto projectDto) {
		System.out.println("In project controller post request");
		System.out.println(projectDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addNewProject(projectDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
		System.out.println("In project controller put request");
		projectDto.setProjectId(id); // Set the ID to ensure we are updating the correct project
		ProjectDto updatedProject = projectService.updateProject(projectDto);
		return ResponseEntity.ok(updatedProject);
	}

}
