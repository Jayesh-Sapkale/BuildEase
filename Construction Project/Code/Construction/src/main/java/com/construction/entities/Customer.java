package com.construction.entities;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

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
		this.setRole("customer");
		this.setAccountCreationDate(LocalDate.now());
	}

}
