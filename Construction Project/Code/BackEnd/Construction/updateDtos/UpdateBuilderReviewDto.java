package com.construction.updateDtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateBuilderReviewDto {
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	private Integer rating;

	@NotNull
	private String review;

}
