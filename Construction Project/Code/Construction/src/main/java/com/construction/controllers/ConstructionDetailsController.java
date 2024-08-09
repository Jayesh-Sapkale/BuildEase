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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/constructionDetails")
public class ConstructionDetailsController {

    @Autowired
    private ConstructionDetailsService constructionDetailsService;

    @PostMapping
    @Operation(summary = "Add new construction detail", operationId = "addNewConstructionDetail")
    public ResponseEntity<?> addNewConstructionDetail(@RequestBody ConstructionDetailsDto constructionDetailsDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(constructionDetailsService.addNewConstructionDetail(constructionDetailsDto));
    }

    @PutMapping(value="/{id}")
    @Operation(summary = "Update construction detail by id", operationId = "updateConstructionDetailById")
    public ResponseEntity<?> updateConstructionDetail(@PathVariable Integer id,
            @RequestBody ConstructionDetailsDto constructionDetailsDto) {
        constructionDetailsDto.setConstructionDetailId(id); // Set the ID to ensure we are updating the correct construction detail
        ConstructionDetailsDto updatedConstructionDetails = constructionDetailsService
                .updateConstructionDetail(constructionDetailsDto);
        return ResponseEntity.ok(updatedConstructionDetails);
    }
}
