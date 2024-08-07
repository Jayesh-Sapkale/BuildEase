package com.buildEase.dtos;

import java.math.BigDecimal;
import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDto{
    private Integer projectId;

    @NotNull
    private Integer builderId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer projectDetailId;

    @NotNull
    private String projectName;

    @NotNull
    @Size(min = 6, max = 6)
    private String pincode;

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @NotNull
    private String projectStatus;

    @NotNull
    private String projectDescription;

    @NotNull
    private Double totalPrice;

    
}

