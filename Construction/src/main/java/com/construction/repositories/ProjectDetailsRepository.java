package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.utils.ProjectDetails;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Integer> {

	
	@Query("select cd from ProjectDetails cd where cd.project.id=:projectId")
	Optional<ProjectDetails> getByProjectId(Integer projectId);
	

}
