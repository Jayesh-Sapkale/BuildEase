package com.construction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.construction.entities.BuilderReview;

public interface BuilderReviewRepository extends JpaRepository<BuilderReview, Integer> {

}
