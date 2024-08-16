package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.construction.dtos.CustomerDto;
import com.construction.entities.Customer;
import com.construction.repositories.CustomerRepository;
import com.construction.service.CustomerService;
import com.construction.updateDtos.UpdateCustomerDto;

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
		
		System.out.println(customerDto);
		Customer customer = modelMapper.map(customerDto, Customer.class);
		Customer savedCustomer = customerRepository.save(customer); // This persists the entity and returns the managed
									
		CustomerDto savedCustomerDto = modelMapper.map(savedCustomer, CustomerDto.class);
		savedCustomerDto.setName(customerDto.getBasicDetails().getFirstName()+" "+customerDto.getBasicDetails().getLastName());
		savedCustomerDto.setCity(customerDto.getAddress().getCity());
		savedCustomerDto.setContactNumber(customerDto.getContactDetails().getContactNumber());// entity
		return savedCustomerDto; // Convert the saved entity back to DTO and return
	}

	@Override
	public CustomerDto updateCustomer(UpdateCustomerDto updateCustomerDto) {
		Integer id = updateCustomerDto.getId();
		Customer customer = customerRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found with ID: " +id));
		modelMapper.map(updateCustomerDto, customer);
		System.out.println(updateCustomerDto);
		Customer updatedCustomer = customerRepository.save(customer);
		CustomerDto savedCustomerDto = modelMapper.map(updatedCustomer, CustomerDto.class);
		savedCustomerDto.setName(updateCustomerDto.getName());
		savedCustomerDto.setContactNumber(updateCustomerDto.getContactNumber());// entity
		savedCustomerDto.setCity(updatedCustomer.getAddress().getCity());// entity
		
		return savedCustomerDto; 
	}

}
