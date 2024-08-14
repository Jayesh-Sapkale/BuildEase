package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.utils.ConstructionDetails;

public interface ConstructionDetailsRepository extends JpaRepository<ConstructionDetails, Integer> {

	
	@Query("select cd from ConstructionDetails cd where cd.builder.id=:builderId")
	Optional<ConstructionDetails> getByBuilderId(Integer builderId);
	

}
