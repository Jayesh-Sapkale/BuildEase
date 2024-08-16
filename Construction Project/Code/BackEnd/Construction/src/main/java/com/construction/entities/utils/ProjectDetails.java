package com.construction.entities.utils;

import com.construction.enums.ConstructionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ProjectDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer constructionDetailId;

	@NotNull
	private double areaInSqFt;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ConstructionType constructionType;

	@NotNull
	private String constructionDescription;
}
