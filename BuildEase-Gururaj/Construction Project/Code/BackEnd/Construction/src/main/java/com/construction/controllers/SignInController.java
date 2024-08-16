package com.construction.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.construction.customExceptions.SignInException;
import com.construction.dtos.SignInDto;
import com.construction.service.SignInService;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/signIn")
public class SignInController {

	@Autowired
	private SignInService signInService;

	@PostMapping(value = "/Admin")
	@Operation(summary = "Get admin by username and password", operationId = "Admin")
	public ResponseEntity<?> getAdmin(@RequestBody SignInDto signInDto) throws SignInException {

		return ResponseEntity.ok(signInService.adminSignIn(signInDto));
	}

	@PostMapping(value = "/Customer")
	@Operation(summary = "Get customer by username and password", operationId = "Customer")
	public ResponseEntity<?> getCustomer(@RequestBody SignInDto signInDto) throws SignInException {
		System.out.println(signInDto);
		return ResponseEntity.ok(signInService.customerSignIn(signInDto));
	}

	@PostMapping(value = "/Builder")
	@Operation(summary = "Get builder by username and password", operationId = "Builder")
	public ResponseEntity<?> getBuilder(@RequestBody SignInDto signInDto) throws SignInException {
		return ResponseEntity.ok(signInService.builderSignIn(signInDto));
	}
}
