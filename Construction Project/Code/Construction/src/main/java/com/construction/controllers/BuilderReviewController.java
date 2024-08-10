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

import com.construction.dtos.BuilderReviewDto;
import com.construction.service.BuilderReviewService;
import com.construction.updateDtos.UpdateBuilderReviewDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/builderReview")
public class BuilderReviewController {

    @Autowired
    private BuilderReviewService builderReviewService;

    @PostMapping(value="/addNewBuilderReview")
    @Operation(summary = "Add new builder review", operationId = "addNewBuilderReview")
    public ResponseEntity<?> addNewBuilderReview(@RequestBody BuilderReviewDto builderReviewDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(builderReviewService.addNewBuilderReview(builderReviewDto));
    }

    @PutMapping(value="/updateBuilderReviewById/{id}")
    @Operation(summary = "Update builder review by id", operationId = "updateBuilderReviewById")
    public ResponseEntity<?> updateBuilderReview(@PathVariable Integer id,
            @RequestBody UpdateBuilderReviewDto builderReviewUpdateDto) {
        builderReviewUpdateDto.setId(id); // Set the ID to ensure we are updating the correct builderReview
        BuilderReviewDto updatedBuilderReview = builderReviewService.updateBuilderReview(builderReviewUpdateDto);
        return ResponseEntity.ok(updatedBuilderReview);
    }
}
