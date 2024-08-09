package com.construction.dtos;

import com.construction.entities.User;
import com.construction.enums.Availability;
import com.construction.enums.ConstructionType;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderDto extends User {
	
	private int yearsOfExperience;

	@NotNull
	private double ratePerMonth;

	private ConstructionType constructionType; 

	@Size(min = 10, max = 10)
	private String emergencyContactNumber;

	private Availability availability; 


}
