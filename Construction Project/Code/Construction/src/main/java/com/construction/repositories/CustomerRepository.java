package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
