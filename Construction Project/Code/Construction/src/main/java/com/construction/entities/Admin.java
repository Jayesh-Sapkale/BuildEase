package com.construction.entities;

import java.time.LocalDate;

import com.construction.enums.Role;
import com.construction.enums.Status;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@AllArgsConstructor
public class Admin extends User {
	
	private LocalDate lastLogin;

	private LocalDate lastPasswordChange;

	public Admin() {
		super();
		this.setRole(Role.ADMIN);
		this.setStatus(Status.ACTIVE);
		this.lastLogin = LocalDate.now();
		this.lastPasswordChange = LocalDate.now();
	}

}
