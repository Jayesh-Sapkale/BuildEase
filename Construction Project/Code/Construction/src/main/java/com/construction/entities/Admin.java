package com.construction.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Admin extends User {

	private LocalDate lastLogin;

	private LocalDate lastPasswordChange;

	public Admin() {
		super();
		this.setRole("admin");
		this.lastLogin = LocalDate.now();
		this.lastPasswordChange = LocalDate.now();
	}

}
