package com.construction.dtos;

import com.construction.enums.Role;
import com.construction.enums.Status;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;
	@JsonProperty(access = Access.READ_ONLY)
	private Role role;
	@JsonProperty(access = Access.READ_ONLY)
	private Status status;
	@NotNull
	private String userName;
	@NotNull
	private String password;

	
	private AddressDto address;

	private BasicDetailsDto basicDetails;

	private ContactDetailsDto contactDetails;

}
