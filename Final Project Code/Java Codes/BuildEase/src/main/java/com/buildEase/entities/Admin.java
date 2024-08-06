package com.buildEase.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
public class Admin extends BaseClass {
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastPasswordChange;


	public Admin() {
		super();
		this.setRole("admin");
	}
	
	
    
    
    
    
  

	
    
    
}

