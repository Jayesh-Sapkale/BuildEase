package com.buildEase.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderReviewDto {
    private Integer reviewId;

    @NotNull
    private Integer userId;

    @NotNull
    private Integer builderId;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer rating;

    @NotNull
    private String review;

    @NotNull
    private LocalDate reviewDate;
}

