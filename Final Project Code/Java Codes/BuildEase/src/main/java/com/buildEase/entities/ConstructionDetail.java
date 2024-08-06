package com.buildEase.entities;

import com.buildEase.enums.ConstructionType;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ConstructionDetail")
public class ConstructionDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer projectDetailId;

    @OneToOne
    @JoinColumn(name = "projectId")
    private Project project;

    @NotNull
    private double areaInSqFt;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ConstructionType constructionType; // Enum values: [WAREHOUSE, HOUSE, APARTMENT, MALL]

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String builderName;

    @NotNull
    private String constructionDescription;
}
