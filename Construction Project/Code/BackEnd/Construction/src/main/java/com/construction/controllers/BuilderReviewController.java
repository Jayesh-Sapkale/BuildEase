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

import com.construction.dtos.BuilderReviewDto;
import com.construction.service.BuilderReviewService;
import com.construction.updateDtos.UpdateBuilderReviewDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/builderReview")
public class BuilderReviewController {

    @Autowired
    private BuilderReviewService builderReviewService;

    @PostMapping(value="/addNewBuilderReviewByBuilderAndCustomerId/{customerId}/{builderId}")
    @Operation(summary = "Add new builder review", operationId = "addNewBuilderReviewByBuilderId")
    public ResponseEntity<?> addNewBuilderReviewByBuilderId(@RequestBody BuilderReviewDto builderReviewDto,@PathVariable Integer customerId,@PathVariable Integer builderId) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(builderReviewService.addNewBuilderReviewByCustomerAndBuilderId(builderReviewDto,customerId,builderId));
    }
    

    @PutMapping(value="/updateBuilderReviewById/{id}")
    @Operation(summary = "Update builder review by id", operationId = "updateBuilderReviewById")
    public ResponseEntity<?> updateBuilderReview(@PathVariable Integer id,
            @RequestBody UpdateBuilderReviewDto builderReviewUpdateDto) {
        builderReviewUpdateDto.setId(id); // Set the ID to ensure we are updating the correct builderReview
        BuilderReviewDto updatedBuilderReview = builderReviewService.updateBuilderReview(builderReviewUpdateDto);
        return ResponseEntity.ok(updatedBuilderReview);
    }
    
    @GetMapping(value="/getBuilderReviewsByBuilderId/{id}")
    @Operation(summary = "Get all builder review by builder id", operationId = "getBuilderReviewsByBuilderId")
    public ResponseEntity<?> getAllBuilderReviewsByBuilderId(@PathVariable Integer id) {
        return ResponseEntity.ok(builderReviewService.getBuilderReviewsByBuilderId(id));
    }
}
