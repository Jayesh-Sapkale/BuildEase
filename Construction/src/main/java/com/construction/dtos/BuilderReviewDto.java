package com.construction.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class BuilderReviewDto  {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer builderReviewId;
	

	@JsonProperty(access = Access.READ_ONLY)
	private String customerName;

	@JsonProperty(access = Access.READ_ONLY)
	private String builderName;

	@Min(0)
	@Max(5)
	private int rating;

	private String review;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate reviewDate;

}
