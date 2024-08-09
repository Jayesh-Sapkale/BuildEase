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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping
    @Operation(summary = "Add new project", operationId = "addNewProject")
    public ResponseEntity<?> addNewProject(@RequestBody ProjectDto projectDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.addNewProject(projectDto));
    }

    @PutMapping(value="/{id}")
    @Operation(summary = "Update project by id", operationId = "updateProjectById")
    public ResponseEntity<?> updateProject(@PathVariable Integer id, @RequestBody ProjectDto projectDto) {
        projectDto.setProjectId(id); // Set the ID to ensure we are updating the correct project
        ProjectDto updatedProject = projectService.updateProject(projectDto);
        return ResponseEntity.ok(updatedProject);
    }
}
