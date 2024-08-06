package com.buildEase.entities;

import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data

public class User extends BaseClass {
	public User() {
		super();
		this.setRole("User");
		// TODO Auto-generated constructor stub
	}

}
