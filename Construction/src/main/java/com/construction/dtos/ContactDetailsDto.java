package com.construction.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ContactDetailsDto {
	
	@NotNull
	@Size(min=10,max=10)
	private String contactNumber;
	@NotNull
	@Email
	private String email;
	private String url;

}
