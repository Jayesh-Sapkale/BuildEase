package com.construction.updateDtos;

import com.construction.enums.ConstructionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCompanyDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;

	private String city;

	private String contactNumber;

	private String companyName;

	private ConstructionType constructionType;

	private double annualRevenue;

	private int numberOfEmployees;

}
