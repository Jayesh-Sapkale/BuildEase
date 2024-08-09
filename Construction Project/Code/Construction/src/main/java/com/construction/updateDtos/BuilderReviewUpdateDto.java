package com.construction.updateDtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderReviewUpdateDto {
	@JsonProperty(access = Access.READ_ONLY)
    private Integer reviewId;

    @NotNull
	@JsonProperty(access = Access.READ_ONLY)
    private Integer userId;

    @NotNull
	@JsonProperty(access = Access.READ_ONLY)
    private Integer builderId;

    @NotNull
    @Min(0)
    @Max(5)
    private Integer rating;

    @NotNull
	@JsonProperty(access = Access.READ_ONLY)
    private String review;

    @NotNull
	@JsonProperty(access = Access.READ_ONLY)
    private LocalDate reviewDate;
}

