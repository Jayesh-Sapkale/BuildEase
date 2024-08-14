package com.construction.service;

import com.construction.dtos.AdminDto;
import com.construction.dtos.BuilderDto;
import com.construction.dtos.CustomerDto;
import com.construction.dtos.SignInDto;

public interface SignInService {

	public BuilderDto builderSignIn(SignInDto singInDto);

	public CustomerDto customerSignIn(SignInDto singInDto);
	
	public AdminDto adminSignIn(SignInDto singInDto);
	

}
