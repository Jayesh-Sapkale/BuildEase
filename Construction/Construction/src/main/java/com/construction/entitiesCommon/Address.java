package com.construction.entitiesCommon;

import jakarta.persistence.*;
import lombok.Data;


@Table(name = "address")
@Data
@Embeddable
public class Address {

	@Column(nullable = false)
	private String country;
	
	@Column(nullable = false)
	private String state;
	
	@Column(nullable = false)
	private String city;
	
	@Column(nullable = false, length = 10)
	private String pinCode;
	
    @Column(nullable = false)
    private String street;


}

  


