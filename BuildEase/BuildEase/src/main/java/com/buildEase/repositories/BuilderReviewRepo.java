package com.buildEase.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buildEase.entities.BuilderReview;

public interface BuilderReviewRepo extends JpaRepository<BuilderReview, Integer> {

}
