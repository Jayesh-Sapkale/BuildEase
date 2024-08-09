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

import com.construction.dtos.CustomerDto;
import com.construction.service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@PostMapping
	public ResponseEntity<?> addNewCustomer(@RequestBody CustomerDto customerDto) {
		System.out.println("In customer controller post request");
		System.out.println(customerDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addNewCustomer(customerDto));

	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
		System.out.println("In customer controller put request");
		customerDto.setId(id); // Set the ID to ensure we are updating the correct customer
		CustomerDto updatedCustomer = customerService.updateCustomer(customerDto);
		return ResponseEntity.ok(updatedCustomer);
	}

}
