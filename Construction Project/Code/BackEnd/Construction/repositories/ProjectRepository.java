package com.construction.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
	@Query("select p from Project p where p.builder.id = :builderId")
	List<Project> findProjectByBuilderId(Integer builderId);

	@Query("select p from Project p where p.customer.id = :customerId")
	Optional<Project> findProjectByCustomerId(Integer customerId);

	@Query("select p from Project p where p.builder.id = :builderId")
	Optional<Project> findByBuilderId(Integer builderId);
}
