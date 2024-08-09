package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.utils.ConstructionDetails;

public interface ConstructionDetailsRepository extends JpaRepository<ConstructionDetails, Integer> {

}
