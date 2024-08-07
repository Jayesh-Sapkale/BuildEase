package com.buildEase.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.buildEase.entities.ConstructionDetail;
import com.buildEase.entities.Project;

public interface ConstructionDetailRepository extends JpaRepository<ConstructionDetail, Integer> {

	
}
