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

@RestController
@RequestMapping("/builderReview")
public class BuilderReviewController {

	@Autowired
	private BuilderReviewService builderReviewService;

	@PostMapping
	public ResponseEntity<?> addNewBuilderReview(@RequestBody BuilderReviewDto builderReviewDto) {
		System.out.println("In builderReview controller post request");
		System.out.println(builderReviewDto);
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(builderReviewService.addNewBuilderReview(builderReviewDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateBuilderReview(@PathVariable Integer id,
			@RequestBody BuilderReviewDto builderReviewDto) {
		System.out.println("In builderReview controller put request");
		builderReviewDto.setId(id); // Set the ID to ensure we are updating the correct builderReview
		BuilderReviewDto updatedBuilderReview = builderReviewService.updateBuilderReview(builderReviewDto);
		return ResponseEntity.ok(updatedBuilderReview);
	}

}
