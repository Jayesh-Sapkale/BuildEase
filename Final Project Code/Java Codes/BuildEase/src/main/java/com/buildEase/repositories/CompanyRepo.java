package com.buildEase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildEase.entities.Company;

public interface CompanyRepo extends JpaRepository<Company, Integer> {

}
