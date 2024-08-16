package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Query("select c from Company c where c.builder.id=:builderId")
	Company findCompanyByBuilderId(Integer builderId);
	
	

}
