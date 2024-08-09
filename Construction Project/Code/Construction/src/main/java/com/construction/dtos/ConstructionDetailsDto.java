package com.construction.dtos;

import com.construction.enums.ConstructionType;
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
public class ConstructionDetailsDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer constructionDetailId; // constructionDetailId

	@NotNull
	private double areaInSqFt;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

	@NotNull
	private String builderName;

	@NotNull
	private String constructionDescription;

}
