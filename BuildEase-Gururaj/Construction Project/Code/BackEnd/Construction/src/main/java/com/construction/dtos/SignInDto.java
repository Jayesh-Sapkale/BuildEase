package com.construction.dtos;

import com.construction.enums.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignInDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer signInId;

	@NotNull
	private String userName;
	@NotNull	
	private String password;
	
	@JsonProperty(access = Access.READ_ONLY)
	private Role role;
	

}
