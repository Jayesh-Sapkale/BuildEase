package com.buildEase.dtos;

import java.math.BigDecimal;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderDto extends BaseClassDto {

	@Min(0)
	@Max(20)
	private Integer yearsOfExperience;

	@DecimalMin("0.0")
	private Double ratePerMonth;

	@NotNull
	private String constructionType;

	@NotNull
	@Size(min = 10, max = 10)
	private String emergencyContactNumber;

	@NotNull
	private String availability;

}
