package com.buildEase.entities;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Admin")
@Data
@AllArgsConstructor
public class Admin extends BaseClass {
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate lastLogin;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDate lastPasswordChange;


	public Admin() {
		super();
		this.setRole("admin");
	}
	
	
    
    
    
    
  

	
    
    
}

