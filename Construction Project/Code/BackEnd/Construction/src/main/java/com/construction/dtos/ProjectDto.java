package com.construction.dtos;

import java.time.LocalDate;

import com.construction.enums.RequestStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer projectId;

	@JsonProperty(access = Access.WRITE_ONLY)
	private ProjectDetailsDto constructionDetails;

	@JsonProperty(access = Access.READ_ONLY)
	private String builderName;
	@JsonProperty(access = Access.READ_ONLY)
	private String customerName;
	@JsonProperty(access = Access.READ_ONLY)
	private String constructionType;
	@JsonProperty(access = Access.READ_ONLY)
	private String city;

	@JsonProperty(access = Access.WRITE_ONLY)
	private AddressDto address;

	@NotNull
	private String projectName;

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;

	@JsonProperty(access = Access.READ_ONLY)
	private RequestStatus requestStatus;

	@NotNull
	private String projectDescription;

	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	private double totalPrice; // Auto-generate as per (rate * area per square feet)

}
