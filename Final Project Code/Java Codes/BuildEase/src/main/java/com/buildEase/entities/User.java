package com.buildEase.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "User")
@AllArgsConstructor
public class User extends BaseClass {

	@Temporal(TemporalType.DATE)
	@NotNull
	private LocalDate creationDate;

	public User() {
		super();
		this.setRole("user");
		// TODO Auto-generated constructor stub
	}

}
