package com.buildEase.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.validator.constraints.URL;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {
	
	
    private Integer companyId;

    @NotNull
    private Integer builderId;

    @NotNull
    @Pattern(regexp = "^[A-Za-z]+$")
    private String name;

    @NotNull
    private String address;

    @NotNull
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @URL
    private String website;

    @NotNull
    private LocalDate foundingDate;

    @NotNull
    @Min(5)
    @Max(5)
    private Integer licenseNumber;

    @NotNull
    private String constructionType;

    @NotNull
    private Double annualRevenue;

    @NotNull
    @Min(5)
    private Integer numberOfEmployees;

    @NotNull
    public String ConstructionType ;
}

