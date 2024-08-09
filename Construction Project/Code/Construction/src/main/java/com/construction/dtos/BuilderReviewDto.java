package com.construction.dtos;

import java.time.LocalDate;

import com.construction.entities.Builder;
import com.construction.entities.Customer;
import com.construction.entities.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderReviewDto extends User {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer builderReviewId;

	private Customer customer;

	private Builder builder;

	@Min(0)
	@Max(5)
	private int rating;

	private String review;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate reviewDate;

}
