package com.construction.entities;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.construction.enums.Role;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class SignIn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer signInId;

	@NotNull
	private String userName;
	
	@NotNull
	private String password;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@NotNull
	@DateTimeFormat
	private LocalDateTime signInLog;

	public SignIn() {
		this.signInLog = LocalDateTime.now();
	}

}
