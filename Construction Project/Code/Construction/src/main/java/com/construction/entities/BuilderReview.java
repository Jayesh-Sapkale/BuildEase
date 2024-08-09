package com.construction.entities;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Entity
@Table
public class BuilderReview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer builderReviewId;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "customerId")
	private Customer customer;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "builderId")
	private Builder builder;

	@Min(0)
	@Max(5)
	private int rating;

	private String review;

	@NotNull
	private LocalDate reviewDate;
	
	public BuilderReview() {
		super();
		this.setReviewDate(LocalDate.now());
	}

}
