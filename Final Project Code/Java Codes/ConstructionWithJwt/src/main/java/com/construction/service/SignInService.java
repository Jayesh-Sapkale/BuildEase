package com.construction.service;

import com.construction.customExceptions.SignInException;
import com.construction.dtos.AdminDto;
import com.construction.dtos.BuilderDto;
import com.construction.dtos.CustomerDto;
import com.construction.dtos.SignInDto;

public interface SignInService {

	public BuilderDto builderSignIn(SignInDto singInDto) throws SignInException;

	public CustomerDto customerSignIn(SignInDto singInDto) throws SignInException;
	
	public AdminDto adminSignIn(SignInDto singInDto) throws SignInException;
	
	

}
