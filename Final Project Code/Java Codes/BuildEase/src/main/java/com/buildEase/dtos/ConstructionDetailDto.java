package com.buildEase.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConstructionDetailDto {
    private Integer projectDetailId;

    @NotNull
    private Integer projectId;

    @NotNull
    private Double areaInSqFt;

    @NotNull
    private String constructionType;

    @NotNull
    private String builderName;

    @NotNull
    private String constructionDescription;

}
