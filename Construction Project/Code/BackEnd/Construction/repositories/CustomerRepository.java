package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	@Query("select c from Customer c where c.userName=:userName and c.password=:password")
	Optional<Customer> findCustomerByUser(String userName, String password);

	@Query("select c.userName from Customer c where c.userName=:userName")
	Optional<String> validateUsername(String userName);

	@Query("select c.password from Customer c where c.password=:password")
	Optional<String> validatePassword(String password);

}
