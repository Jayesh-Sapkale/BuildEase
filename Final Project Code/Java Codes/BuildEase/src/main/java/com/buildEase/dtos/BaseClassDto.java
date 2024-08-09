package com.buildEase.dtos;

import java.time.LocalDate;

import com.buildEase.entities.Address;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseClassDto {
	
	@JsonProperty(access = Access.READ_ONLY)
	private Integer id;

    @NotNull
    @Size(min = 10)
    private String username;

    @NotNull
    @Size(min = 10)
    private String password;

    @NotNull
    private String firstName;

    @NotNull
    private String lastName;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    private String gender;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    private String phone;

    @NotNull
    private Address address;

    @NotNull
    @JsonProperty(access = Access.READ_ONLY)
    private String role;
}
