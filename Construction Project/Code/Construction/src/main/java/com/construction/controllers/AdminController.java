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

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<?> addNewAdmin(@RequestBody AdminDto adminDto) {
		System.out.println("In admin controller post request");
		System.out.println(adminDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addNewAdmin(adminDto));

	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getAdminById(@PathVariable Integer id) {
		System.out.println("In admin controller get by id request");
		return ResponseEntity.ok(adminService.getAdminById(id));
	}

	@GetMapping("/getAllAdmins")
	public ResponseEntity<?> getAllAdmins() {
		System.out.println("In admin controller get request");
		return ResponseEntity.ok(adminService.getAllAdmins());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer id, @RequestBody AdminDto adminDto) {
		System.out.println("In admin controller put request");
		adminDto.setId(id); // Set the ID to ensure we are updating the correct admin
		AdminDto updatedAdmin = adminService.updateAdmin(adminDto);
		return ResponseEntity.ok(updatedAdmin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeAdmin(@PathVariable Integer id) {
		System.out.println("In admin controller delete by id request");
		return ResponseEntity.ok(adminService.removeAdmin(id));
	}

	@DeleteMapping("/deleteAllAdmins")
	public ResponseEntity<?> removeAllAdmins() {
		System.out.println("In admin controller delete request");
		return ResponseEntity.ok(adminService.removeAllAdmins());
	}

	@GetMapping("/customer/{id}")
	public ResponseEntity<?> getCustomerById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.getCustomerById(id));
	}

	@GetMapping("/getAllCustomers")
	public ResponseEntity<?> getAllCustomers() {
		return ResponseEntity.ok(adminService.getAllCustomers());
	}

	@DeleteMapping("/customer/{id}")
	public ResponseEntity<?> removeCustomer(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeCustomer(id));
	}

	@DeleteMapping("/deleteAllCustomers")
	public ResponseEntity<?> removeAllCustomers() {
		return ResponseEntity.ok(adminService.removeAllCustomers());
	}

	@GetMapping("/builder/{id}")
	public ResponseEntity<?> getBuilderById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.getBuilderById(id));
	}

	@GetMapping("/getAllBuilders")
	public ResponseEntity<?> getAllBuilders() {
		return ResponseEntity.ok(adminService.getAllBuilders());
	}

	@DeleteMapping("/builder/{id}")
	public ResponseEntity<?> removeBuilder(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeBuilder(id));
	}

	@DeleteMapping("/deleteAllBuilders")
	public ResponseEntity<?> removeAllBuilders() {
		return ResponseEntity.ok(adminService.removeAllBuilders());
	}

	@GetMapping("/builderReview/{id}")
	public ResponseEntity<?> getBuilderReviewById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.getBuilderReviewById(id));
	}

	@GetMapping("/getAllBuilderReviews")
	public ResponseEntity<?> getAllBuilderReviews() {
		return ResponseEntity.ok(adminService.getAllBuilderReviews());
	}

	@DeleteMapping("/builderReview/{id}")
	public ResponseEntity<?> removeBuilderReview(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeBuilderReview(id));
	}

	@DeleteMapping("/deleteAllBuilderReviews")
	public ResponseEntity<?> removeAllBuilderReviews() {
		return ResponseEntity.ok(adminService.removeAllBuilderReviews());
	}

	@GetMapping("/builderReview/ratings/{builderId}")
	public ResponseEntity<?> getRatings(@PathVariable Integer builderId) {
		return ResponseEntity.ok(adminService.getRatings(builderId));
	}

	@GetMapping("/company/{id}")
	public ResponseEntity<?> getCompanyById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.getCompanyById(id));
	}

	@GetMapping("/getAllBuilderCompanies")
	public ResponseEntity<?> getAllCompanies() {
		return ResponseEntity.ok(adminService.getAllCompanies());
	}

	@GetMapping("/company/builder/{builderId}")
	public ResponseEntity<?> getCompanyByBuilderId(@PathVariable Integer builderId) {
		return ResponseEntity.ok(adminService.getCompanyByBuilderId(builderId));
	}

	@DeleteMapping("/company/builder/{builderId}")
	public ResponseEntity<?> removeCompanyByBuilderId(@PathVariable Integer builderId) {
		return ResponseEntity.ok(adminService.removeCompanyByBuilderId(builderId));
	}

	@DeleteMapping("/deleteAllBuilderCompanies")
	public ResponseEntity<?> removeAllCompanies() {
		return ResponseEntity.ok(adminService.removeAllCompanies());
	}

	@GetMapping("/constructionDetails/{constructionId}")
	public ResponseEntity<?> getConstructionDetailsById(@PathVariable Integer constructionId) {
		return ResponseEntity.ok(adminService.getConstructionDetailsById(constructionId));
	}

	@GetMapping("/getAllBuilderConstructionDetails")
	public ResponseEntity<?> getAllConstructionDetails() {
		return ResponseEntity.ok(adminService.getAllConstructionDetails());
	}

	@DeleteMapping("/constructionDetails/{id}")
	public ResponseEntity<?> removeConstructionDetailsById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeConstructionDetailsById(id));
	}

	@DeleteMapping("/deleteAllBuilderConstructionDetails")
	public ResponseEntity<?> removeAllConstructionDetails() {
		return ResponseEntity.ok(adminService.removeAllConstructionDetails());
	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<?> getProjectByProjectId(@PathVariable Integer projectId) {
		return ResponseEntity.ok(adminService.getProjectByProjectId(projectId));
	}

	@GetMapping("/project/builder/{builderId}")
	public ResponseEntity<?> getProjectsByBuilderId(@PathVariable Integer builderId) {
		return ResponseEntity.ok(adminService.getProjectsByBuilderId(builderId));
	}

	@GetMapping("/project/customer/{customerId}")
	public ResponseEntity<?> getProjectByCustomerId(@PathVariable Integer customerId) {
		return ResponseEntity.ok(adminService.getProjectByCustomerId(customerId));
	}

	@GetMapping("/getAllBuilderProjects")
	public ResponseEntity<?> getAllProjects() {
		return ResponseEntity.ok(adminService.getAllProjects());
	}

	@DeleteMapping("/project/{id}")
	public ResponseEntity<?> removeProjectById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeProjectById(id));
	}

	@DeleteMapping("/deleteAllBuilderProjects")
	public ResponseEntity<?> removeAllProjects() {
		return ResponseEntity.ok(adminService.removeAllProjects());
	}

}
