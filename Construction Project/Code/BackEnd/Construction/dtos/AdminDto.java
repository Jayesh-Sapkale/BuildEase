package com.construction.dtos;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto extends UserDto {

	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;

	@JsonProperty(access = Access.WRITE_ONLY)
	private AddressDto address;

	@JsonProperty(access = Access.WRITE_ONLY)
	private BasicDetailsDto basicDetails;

	@JsonProperty(access = Access.WRITE_ONLY)
	private ContactDetailsDto contactDetails;

	@JsonProperty(access = Access.READ_ONLY)
	private String city;

	@JsonProperty(access = Access.READ_ONLY)
	private String name;

	@JsonProperty(access = Access.READ_ONLY)
	private String contactNumber;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate lastLogin;

	@JsonProperty(access = Access.READ_ONLY)
	private LocalDate lastPasswordChange;

}
