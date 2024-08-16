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
public class Customer extends User {


	private LocalDate accountCreationDate;

	public Customer() {
		super();
		this.setRole(Role.CUSTOMER);
		this.setStatus(Status.ACTIVE);
		this.setAccountCreationDate(LocalDate.now());
	}

}
