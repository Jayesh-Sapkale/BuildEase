package com.buildEase.entities;

import com.buildEase.enums.Availability;
import com.buildEase.enums.ConstructionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Table(name = "Builder")
public class Builder extends BaseClass {
    @NotNull
    @Min(0)
    @Max(20)
    private int yearsOfExperience;

    @NotNull
    @DecimalMin("0.0")
    private double ratePerMonth;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

    @NotNull
    @Size(min = 10, max = 10)
    private String emergencyContactNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Availability availability; // Enum values: [YES, NO]
    
    public Builder() {
		super();
		this.setRole("builder");
	}
}

