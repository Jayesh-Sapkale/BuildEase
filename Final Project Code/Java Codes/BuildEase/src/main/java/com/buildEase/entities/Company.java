package com.buildEase.entities;

import java.time.LocalDate;

import com.buildEase.enums.ConstructionType;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer companyId;
    
    @JoinColumn(name = "")
    private Builder builder;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;

    @NotNull
    @Embedded
    private Address address;

    @Embedded
    private ContactDetails contactDetails;

    @NotNull
    @Temporal(TemporalType.DATE)
    private LocalDate foundingDate;

    @NotNull
    @Min(5)
    @Max(5)
    private int licenseNumber;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

    @NotNull
    private double annualRevenue;

    @NotNull
    @Min(5)
    private int numberOfEmployees;
}

