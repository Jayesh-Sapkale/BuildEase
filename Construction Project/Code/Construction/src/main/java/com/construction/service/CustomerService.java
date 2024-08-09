package com.construction.service;

import com.construction.dtos.CustomerDto;

public interface CustomerService {

	public CustomerDto addNewCustomer(CustomerDto customerDto);

	public CustomerDto updateCustomer(CustomerDto customerDto);



}
