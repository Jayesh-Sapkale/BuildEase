package com.buildEase.dtos;

import com.buildEase.entities.Address;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {
	
	  @NonNull
	    private String city;

	    @NonNull
		@Size(min = 6, max = 6)
	    private String pincode;

	    @NonNull
	    private String state;

	    @NonNull
	    private String addressLine1;
	
	

}
