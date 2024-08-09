package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.CustomerDto;
import com.construction.entities.Customer;
import com.construction.repositories.CustomerRepository;
import com.construction.service.CustomerService;

import jakarta.persistence.EntityNotFoundException;

@Service
@Transactional
public class CustomerServiceImplementation implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CustomerDto addNewCustomer(CustomerDto customerDto) {
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Customer savedCustomer = customerRepository.save(customer); // This persists the entity and returns the managed
																	// entity
		return modelMapper.map(savedCustomer, CustomerDto.class); // Convert the saved entity back to DTO and return
	}

	@Override
	public CustomerDto updateCustomer(CustomerDto customerDto) {
		Customer customer = customerRepository.findById(customerDto.getId())
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " + customerDto.getId()));
		modelMapper.map(customerDto, customer);
		Customer updatedCustomer = customerRepository.save(customer);
		return modelMapper.map(updatedCustomer, CustomerDto.class);
	}

}
