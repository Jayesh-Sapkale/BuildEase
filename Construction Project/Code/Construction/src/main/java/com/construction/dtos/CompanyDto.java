package com.construction.dtos;

import java.time.LocalDate;

import com.construction.entities.Builder;
import com.construction.entities.utils.Address;
import com.construction.entities.utils.ContactDetails;
import com.construction.enums.ConstructionType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer companyId;

	private Builder builder;

	@NotNull
	private String name;

	@NotNull
	private Address address;

	@NotNull
	private ContactDetails contactDetails;

	
	private LocalDate foundingDate;

	@NotNull
	@Min(10000)
	@Max(99999)
	private Integer licenseNumber;

	@NotNull
	@Enumerated(EnumType.STRING)
	private ConstructionType constructionType;

	private double annualRevenue;

	private int numberOfEmployees;

}
