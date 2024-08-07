package com.buildEase.controllers;

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

import com.buildEase.dtos.AdminDto;
import com.buildEase.service.AdminService;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping
	public ResponseEntity<?> addNewAdmin(@RequestBody AdminDto adminDto) {
		System.out.println("In admin controller post request");
		return ResponseEntity.status(HttpStatus.CREATED).body(adminService.addNewAdmin(adminDto));

	}

	@GetMapping("/{id}/admin")
	public ResponseEntity<?> getAdminById(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.getAdminById(id));
	}

	@GetMapping
	public ResponseEntity<?> getAllAdmins() {
		return ResponseEntity.ok(adminService.getAllAdmin());
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateAdmin(@PathVariable Integer id, @RequestBody AdminDto adminDto) {
		adminDto.setId(id); // Set the ID to ensure we are updating the correct admin
		AdminDto updatedAdmin = adminService.updateAdmin(adminDto);
		return ResponseEntity.ok(updatedAdmin);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> removeAdmin(@PathVariable Integer id) {
		return ResponseEntity.ok(adminService.removeAdmin(id));
	}

	@DeleteMapping
	public ResponseEntity<?> removeAllAdmins() {

		return ResponseEntity.ok(adminService.removeAllAdmins());
	}
}
