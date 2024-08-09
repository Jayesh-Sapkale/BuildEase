package com.construction.entities.utils;

import com.construction.enums.ConstructionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class ConstructionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
