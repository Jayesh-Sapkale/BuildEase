package com.construction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.dtos.AdminDto;
import com.construction.service.AdminService;
import com.construction.updateDtos.UpdateAdminDto;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping(value="/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/signUp")
    @Operation(summary = "Add new admin", operationId = "addNewAdmin")
    public ResponseEntity<?> addNewAdmin(@RequestBody AdminDto adminDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addNewAdmin(adminDto));
    }

    @GetMapping(value="/getAdminById/{id}")
    @Operation(summary = "Get admin by id", operationId = "getAdminById")
    public ResponseEntity<?> getAdminById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getAdminById(id));
    }

    @GetMapping(value="/getAllAdmins")
    @Operation(summary = "Get all admins", operationId = "getAllAdmins")
    public ResponseEntity<?> getAllAdmins() {
        return ResponseEntity.ok(adminService.getAllAdmins());
    }

    @PutMapping(value="/updateAdminById/{id}")
    @Operation(summary = "Update admin by id", operationId = "updateAdminById")
    public ResponseEntity<?> updateAdmin(@PathVariable Integer id, @RequestBody UpdateAdminDto adminDto) {
        adminDto.setId(id); // Set the ID to ensure we are updating the correct admin
        AdminDto updatedAdmin = adminService.updateAdmin(adminDto);
        return ResponseEntity.ok(updatedAdmin);
    }

    @DeleteMapping(value="/deleteAdminById/{id}")
    @Operation(summary = "Delete admin by id", operationId = "removeAdminById")
    public ResponseEntity<?> removeAdmin(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeAdmin(id));
    }

    @DeleteMapping(value="/removeAllAdmins")
    @Operation(summary = "Delete all admins", operationId = "removeAllAdmins")
    public ResponseEntity<?> removeAllAdmins() {
        return ResponseEntity.ok(adminService.removeAllAdmins());
    }

    @GetMapping(value="/getCustomerById/{id}")
    @Operation(summary = "Get customer by id", operationId = "getCustomerById")
    public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getCustomerById(id));
    }

    @GetMapping(value="/getAllCustomers")
    @Operation(summary = "Get all customers", operationId = "getAllCustomers")
    public ResponseEntity<?> getAllCustomers() {
        return ResponseEntity.ok(adminService.getAllCustomers());
    }

    @DeleteMapping(value="/deleteCustomerById/{id}")
    @Operation(summary = "Delete customer by id", operationId = "removeCustomerById")
    public ResponseEntity<?> removeCustomer(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeCustomer(id));
    }

    @DeleteMapping(value="/deleteAllCustomers")
    @Operation(summary = "Delete all customers", operationId = "removeAllCustomers")
    public ResponseEntity<?> removeAllCustomers() {
        return ResponseEntity.ok(adminService.removeAllCustomers());
    }

    @GetMapping(value="/getBuilderById/{id}")
    @Operation(summary = "Get builder by id", operationId = "getBuilderById")
    public ResponseEntity<?> getBuilderById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getBuilderById(id));
    }

    @GetMapping(value="/getAllBuilders")
    @Operation(summary = "Get all builders", operationId = "getAllBuilders")
    public ResponseEntity<?> getAllBuilders() {
        return ResponseEntity.ok(adminService.getAllBuilders());
    }

    @DeleteMapping(value="/deleteBuilderById/{id}")
    @Operation(summary = "Delete builder by id", operationId = "removeBuilderById")
    public ResponseEntity<?> removeBuilder(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeBuilder(id));
    }

    @DeleteMapping(value="/deleteAllBuilders")
    @Operation(summary = "Delete all builders", operationId = "removeAllBuilders")
    public ResponseEntity<?> removeAllBuilders() {
        return ResponseEntity.ok(adminService.removeAllBuilders());
    }

    @GetMapping(value="/getBuilderReviewById/{id}")
    @Operation(summary = "Get builder review by id", operationId = "getBuilderReviewById")
    public ResponseEntity<?> getBuilderReviewById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getBuilderReviewById(id));
    }

    @GetMapping(value="/getAllBuilderReviews")
    @Operation(summary = "Get all builder reviews", operationId = "getAllBuilderReviews")
    public ResponseEntity<?> getAllBuilderReviews() {
        return ResponseEntity.ok(adminService.getAllBuilderReviews());
    }

    @DeleteMapping(value="/deleteBuilderReviewById/{id}")
    @Operation(summary = "Delete builder review by id", operationId = "removeBuilderReviewById")
    public ResponseEntity<?> removeBuilderReview(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeBuilderReview(id));
    }

    @DeleteMapping(value="/deleteAllBuilderReviews")
    @Operation(summary = "Delete all builder reviews", operationId = "removeAllBuilderReviews")
    public ResponseEntity<?> removeAllBuilderReviews() {
        return ResponseEntity.ok(adminService.removeAllBuilderReviews());
    }

    @GetMapping(value="/getRatingsByBuilderId/{builderId}")
    @Operation(summary = "Get ratings by builder id", operationId = "getRatingsByBuilderId")
    public ResponseEntity<?> getRatings(@PathVariable Integer builderId) {
        return ResponseEntity.ok(adminService.getRatings(builderId));
    }

    @GetMapping(value="/getCompanyById/{id}")
    @Operation(summary = "Get company by id", operationId = "getCompanyById")
    public ResponseEntity<?> getCompanyById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.getCompanyById(id));
    }

    @GetMapping(value="/getAllCompanies")
    @Operation(summary = "Get all companies", operationId = "getAllCompanies")
    public ResponseEntity<?> getAllCompanies() {
        return ResponseEntity.ok(adminService.getAllCompanies());
    }

    @GetMapping(value="/getCompanyByBuilderId/{builderId}")
    @Operation(summary = "Get company by builder id", operationId = "getCompanyByBuilderId")
    public ResponseEntity<?> getCompanyByBuilderId(@PathVariable Integer builderId) {
        return ResponseEntity.ok(adminService.getCompanyByBuilderId(builderId));
    }

    @DeleteMapping(value="/deleteCompanyByBuilderId/{builderId}")
    @Operation(summary = "Delete company by builder id", operationId = "removeCompanyByBuilderId")
    public ResponseEntity<?> removeCompanyByBuilderId(@PathVariable Integer builderId) {
        return ResponseEntity.ok(adminService.removeCompanyByBuilderId(builderId));
    }

    @DeleteMapping(value="/removeAllCompanies")
    @Operation(summary = "Delete all companies", operationId = "removeAllCompanies")
    public ResponseEntity<?> removeAllCompanies() {
        return ResponseEntity.ok(adminService.removeAllCompanies());
    }

    @GetMapping(value="/getConstructionDetailById/{constructionId}")
    @Operation(summary = "Get construction details by id", operationId = "getConstructionDetailById")
    public ResponseEntity<?> getConstructionDetailById(@PathVariable Integer constructionId) {
        return ResponseEntity.ok(adminService.getConstructionDetailById(constructionId));
    }

    @GetMapping(value="/getAllConstructionDetails")
    @Operation(summary = "Get all construction details", operationId = "getAllConstructionDetails")
    public ResponseEntity<?> getAllConstructionDetails() {
        return ResponseEntity.ok(adminService.getAllConstructionDetails());
    }

    @DeleteMapping(value="/removeConstructionDetailById/{id}")
    @Operation(summary = "Delete construction detail by id", operationId = "removeConstructionDetailById")
    public ResponseEntity<?> removeConstructionDetailById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeConstructionDetailById(id));
    }

    @DeleteMapping(value="/removeAllConstructionDetails")
    @Operation(summary = "Delete all construction details", operationId = "removeAllConstructionDetails")
    public ResponseEntity<?> removeAllConstructionDetails() {
        return ResponseEntity.ok(adminService.removeAllConstructionDetails());
    }

    @GetMapping(value="/getProjectByProjectId/{projectId}")
    @Operation(summary = "Get project by id", operationId = "getProjectByProjectId")
    public ResponseEntity<?> getProjectByProjectId(@PathVariable Integer projectId) {
        return ResponseEntity.ok(adminService.getProjectByProjectId(projectId));
    }

    @GetMapping(value="/getProjectsByBuilderId/{builderId}")
    @Operation(summary = "Get projects by builder id", operationId = "getProjectsByBuilderId")
    public ResponseEntity<?> getProjectsByBuilderId(@PathVariable Integer builderId) {
        return ResponseEntity.ok(adminService.getProjectsByBuilderId(builderId));
    }

    @GetMapping(value="/getProjectByCustomerId/{customerId}")
    @Operation(summary = "Get project by customer id", operationId = "getProjectByCustomerId")
    public ResponseEntity<?> getProjectByCustomerId(@PathVariable Integer customerId) {
        return ResponseEntity.ok(adminService.getProjectByCustomerId(customerId));
    }

    @GetMapping(value="/getAllProjects")
    @Operation(summary = "Get all projects", operationId = "getAllProjects")
    public ResponseEntity<?> getAllProjects() {
        return ResponseEntity.ok(adminService.getAllProjects());
    }

    @DeleteMapping(value="/deleteProjectById/{id}")
    @Operation(summary = "Delete project by id", operationId = "removeProjectById")
    public ResponseEntity<?> removeProjectById(@PathVariable Integer id) {
        return ResponseEntity.ok(adminService.removeProjectById(id));
    }

    @DeleteMapping(value="/removeAllProjects")
    @Operation(summary = "Delete all projects", operationId = "removeAllProjects")
    public ResponseEntity<?> removeAllProjects() {
        return ResponseEntity.ok(adminService.removeAllProjects());
    }
    
  
}
