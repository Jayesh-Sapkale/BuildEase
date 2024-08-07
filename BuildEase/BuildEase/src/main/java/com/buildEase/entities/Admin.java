package com.buildEase.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Admin")
@Data
@AllArgsConstructor
public class Admin extends BaseClass {
    @NotNull
    private LocalDate lastLogin;

    @NotNull
    private LocalDate lastPasswordChange;


	public Admin() {
		super();
		this.setRole("admin");
	}
	
	
    
    
    
    
  

	
    
    
}

