package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.ConstructionDetail;

public interface ConstructionDetailRepository extends JpaRepository<ConstructionDetail, Integer> {

}
