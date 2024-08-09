package com.construction.dtos;

import java.time.LocalDate;

import com.construction.entities.Builder;
import com.construction.entities.Customer;
import com.construction.entities.utils.Address;
import com.construction.entities.utils.ConstructionDetails;
import com.construction.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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

	
	private Builder builder;


	private Customer customer;


	private ConstructionDetails constructionDetails;

	@NotNull
	private String projectName;

	private Address address;

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ProjectStatus projectStatus; // Enum values: [COMPLETE, PENDING, IN_PROGRESS]

	@NotNull
	private String projectDescription;

	@NotNull
	private double totalPrice; // Auto-generate as per (rate * area per square feet)

}
