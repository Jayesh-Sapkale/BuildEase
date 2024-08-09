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

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @Operation(summary = "Add new customer", operationId = "addNewCustomer")
    public ResponseEntity<?> addNewCustomer(@RequestBody CustomerDto customerDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.addNewCustomer(customerDto));
    }

    @PutMapping(value = "/{id}")
    @Operation(summary = "Update customer by id", operationId = "updateCustomerById")
    public ResponseEntity<?> updateCustomer(@PathVariable Integer id, @RequestBody CustomerDto customerDto) {
        customerDto.setId(id); // Set the ID to ensure we are updating the correct customer
        CustomerDto updatedCustomer = customerService.updateCustomer(customerDto);
        return ResponseEntity.ok(updatedCustomer);
    }
}
