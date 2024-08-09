package com.construction.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@Entity
@AllArgsConstructor
public class Customer extends User {

	private LocalDate accountCreationDate;
	
	public Customer() {
		super();
		this.setRole("customer");
		this.setAccountCreationDate(LocalDate.now());
	}

}
