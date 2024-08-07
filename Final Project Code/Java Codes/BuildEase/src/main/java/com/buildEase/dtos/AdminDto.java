package com.buildEase.dtos;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto extends BaseClassDto {

	
	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime lastLogin;
	
	@NotNull
	@JsonProperty(access = Access.READ_ONLY)
	private LocalDateTime lastPasswordChange;
}
