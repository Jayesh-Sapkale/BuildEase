package com.buildEase.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.buildEase.entities.Builder;
import com.buildEase.entities.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	@Query("select c from Company c where c.builder.id=:builderId")
	Optional<Company> findCompanyByBuilderId(Integer builderId);
	
}
