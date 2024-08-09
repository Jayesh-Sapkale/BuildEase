package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

}
