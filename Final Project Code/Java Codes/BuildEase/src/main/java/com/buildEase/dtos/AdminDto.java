package com.buildEase.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto extends BaseClassDto {

	@NotNull
	private LocalDateTime lastLogin;
	@NotNull
	private LocalDateTime lastPasswordChange;
}
