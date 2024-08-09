package com.construction.dtos;

import java.time.LocalDate;

import com.construction.entitiesCommon.Address;
import com.construction.enums.ProjectStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProjectDTO {

    private Integer projectId;
    private String projectName;
    private Address address;
    private LocalDate startDate;
    private LocalDate endDate;
    private ProjectStatus projectStatus;
    private String projectDescription;
    private Double totalPrice;
    private Integer builderId; // Reference to builder by ID
    private Integer customerId; // Reference to customer by ID
    private Integer projectDetailId; // Reference to project detail by ID

  
}
