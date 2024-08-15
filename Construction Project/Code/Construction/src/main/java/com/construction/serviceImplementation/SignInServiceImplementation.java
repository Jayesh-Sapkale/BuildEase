package com.construction.serviceImplementation;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.construction.customExceptions.SignInException;
import com.construction.dtos.AdminDto;
import com.construction.dtos.BuilderDto;
import com.construction.dtos.CustomerDto;
import com.construction.dtos.SignInDto;
import com.construction.entities.Admin;
import com.construction.entities.Builder;
import com.construction.entities.Customer;
import com.construction.entities.SignIn;
import com.construction.repositories.AdminRepository;
import com.construction.repositories.BuilderRepository;
import com.construction.repositories.CustomerRepository;
import com.construction.repositories.SignInRepository;
import com.construction.service.SignInService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class SignInServiceImplementation implements SignInService {

	@Autowired
	private BuilderRepository builderRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AdminRepository adminRepository;

	@Autowired
	private SignInRepository signInRepository;

	@Autowired
	private ModelMapper modelMapper;
	
	

	@Override
	public BuilderDto builderSignIn(SignInDto signInDto) throws SignInException {

		String userName = builderRepository.validateUsername(signInDto.getUserName())
				.orElseThrow(() -> new SignInException("Invalid user name!"));
		String password = builderRepository.validatePassword(signInDto.getPassword())
				.orElseThrow(() -> new SignInException("Invalid password!"));

		Builder builder = builderRepository.findBuilderByUser(userName, password)
				.orElseThrow(() -> new EntityNotFoundException("Builder not found, Invalid Credentials! "));

		BuilderDto builderDto = modelMapper.map(builder, BuilderDto.class);

		signInDto.setUserName(builderDto.getUserName());
		signInDto.setPassword(builderDto.getPassword());
		signInDto.setRole(builderDto.getRole());
		builderDto.setName(builder.getBasicDetails().getFirstName() + " " + builder.getBasicDetails().getLastName());
		builderDto.setCity(builder.getAddress().getCity());
		builderDto.setContactNumber(builder.getContactDetails().getContactNumber());

		SignIn signIn = modelMapper.map(signInDto, SignIn.class);

		signInRepository.save(signIn);

		return builderDto;
	}

	@Override
	public CustomerDto customerSignIn(SignInDto signInDto) throws SignInException {

		String userName = customerRepository.validateUsername(signInDto.getUserName())
				.orElseThrow(() -> new SignInException("Invalid user name!"));
		String password = customerRepository.validatePassword(signInDto.getPassword())
				.orElseThrow(() -> new SignInException("Invalid password!"));
		Customer customer = customerRepository.findCustomerByUser(userName, password)
				.orElseThrow(() -> new EntityNotFoundException("Customer not found, Invalid Credentials! "));

		CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);

		signInDto.setUserName(customerDto.getUserName());
		signInDto.setPassword(customerDto.getPassword());
		signInDto.setRole(customerDto.getRole());

		customerDto.setName(customer.getBasicDetails().getFirstName() + " " + customer.getBasicDetails().getLastName());
		customerDto.setCity(customer.getAddress().getCity());
		customerDto.setContactNumber(customer.getContactDetails().getContactNumber());

		SignIn signIn = modelMapper.map(signInDto, SignIn.class);

		signInRepository.save(signIn);

		return customerDto;
	}

	@Override
	public AdminDto adminSignIn(SignInDto signInDto) throws SignInException {
		
		System.out.println(signInDto.getUserName());

		String userName = adminRepository.validateUsername(signInDto.getUserName())
				.orElseThrow(() -> new SignInException("Invalid user name!"));
		String password = adminRepository.validatePassword(signInDto.getPassword())
				.orElseThrow(() -> new SignInException("Invalid password!"));
		Admin admin = adminRepository.findAdmin(userName, password)
				.orElseThrow(() -> new EntityNotFoundException("Admin not found, Invalid Credentials! "));

		AdminDto adminDto = modelMapper.map(admin, AdminDto.class);

		signInDto.setUserName(adminDto.getUserName());
		signInDto.setPassword(adminDto.getPassword());
		signInDto.setRole(adminDto.getRole());

		adminDto.setName(admin.getBasicDetails().getFirstName() + " " + admin.getBasicDetails().getLastName());
		adminDto.setCity(admin.getAddress().getCity());
		adminDto.setContactNumber(admin.getContactDetails().getContactNumber());

		SignIn signIn = modelMapper.map(signInDto, SignIn.class);

		signInRepository.save(signIn);

		return adminDto;
	}

}
