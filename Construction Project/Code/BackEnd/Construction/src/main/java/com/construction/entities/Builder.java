package com.construction.entities;

import com.construction.enums.Availability;
import com.construction.enums.ConstructionType;
import com.construction.enums.Role;
import com.construction.enums.Status;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
public class Builder extends User {

	private int yearsOfExperience;

	@NotNull
	private double ratePerMonth;
	

	@Enumerated(EnumType.STRING)
	private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

	@Size(min = 10, max = 10)
	private String emergencyContactNumber;


	@Enumerated(EnumType.STRING)
	private Availability availability; // Enum values: [YES, NO]

	public Builder(Integer builderId) {
		super();
	}

	public Builder() {
		super();
		this.setRole(Role.BUILDER);
		this.setStatus(Status.ACTIVE);
		
	}

}
