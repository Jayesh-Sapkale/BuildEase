package com.buildEase.entities;

import com.buildEase.enums.ConstructionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class ConstructionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectDetailId;

    @OneToOne(mappedBy = "constructionDetail")
    private Project project;

    @NotNull
    private double areaInSqFt;

    @NotNull
    private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String builderName;

    @NotNull
    private String constructionDescription;
}
