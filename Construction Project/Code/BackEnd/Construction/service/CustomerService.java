package com.construction.service;

import com.construction.dtos.CustomerDto;
import com.construction.updateDtos.UpdateCustomerDto;

public interface CustomerService {

	public CustomerDto addNewCustomer(CustomerDto customerDto);

	public CustomerDto updateCustomer(UpdateCustomerDto updateCustomerDto);



}
