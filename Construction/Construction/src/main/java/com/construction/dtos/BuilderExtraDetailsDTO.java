package com.construction.dtos;



import java.time.LocalDate;

import com.construction.entitiesCommon.Address;
import com.construction.enums.Availability;
import com.construction.enums.ConstructionType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderExtraDetailsDTO {

    private Integer builderId;
    private Integer customerId; // Store the customer's ID instead of the full customer entity
    private Integer yearsOfExperience;
    private Double ratePerMonth;
    private ConstructionType constructionType;
    private String emergencyContactNumber;
    private Availability availability;
    private String name;
    private Address address;
    private String phoneNumber;
    private String email;
    private String website;
    private LocalDate foundingDate;
    private String licenseNumber;
    private Double annualRevenue;
    private Integer numberOfEmployees;


}

