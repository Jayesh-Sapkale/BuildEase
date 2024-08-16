package com.construction.updateDtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProjectDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer projectId;

	@NotNull
	private String constructionType;
	

	@NotNull
	private String projectName;

	@NotNull
	private LocalDate startDate;

	@NotNull
	private LocalDate endDate;


	@NotNull
	private String projectDescription;

	
	

}
