package com.buildEase.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.buildEase.entities.BuilderReview;

public interface BuilderReviewRepository extends JpaRepository<BuilderReview, Integer> {

	
	@Query("select br from BuilderReview br where br.id = :id")
	Optional<BuilderReview> findById(Integer id);
	
	@Query("select br from BuilderReview br")
	List<BuilderReview> findAll();
	
	@Query("select br from BuilderReview br where br.builder.id = :builderId")
	List<BuilderReview> findByBuilderId(Integer builderId);
	
	@Query("select avg(br.rating) from BuilderReview br where br.builder.id = :builderId")
	Double getAverageRating(Integer builderId);

	
	
}
