package com.construction.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.construction.entities.BuilderReview;

public interface BuilderReviewRepository extends JpaRepository<BuilderReview, Integer> {
	
	@Query("select avg(br.rating) from BuilderReview br where br.builder.id = :builderId")
	Double getAverageRating(Integer builderId);

	@Query("select br from BuilderReview br where br.builder.id=:builderId and br.customer.id=:customerId")
	Optional<BuilderReview> findByBuilderByCustomerAndBuilderId(Integer customerId,Integer builderId);

}
