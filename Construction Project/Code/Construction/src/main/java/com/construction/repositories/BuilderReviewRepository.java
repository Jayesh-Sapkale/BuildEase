package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.BuilderReview;

public interface BuilderReviewRepository extends JpaRepository<BuilderReview, Integer> {
	
	@Query("select avg(br.rating) from BuilderReview br where br.builder.id = :builderId")
	Double getAverageRating(Integer builderId);

}
