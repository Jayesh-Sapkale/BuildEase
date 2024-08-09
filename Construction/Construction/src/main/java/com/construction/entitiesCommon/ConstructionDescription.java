package com.construction.entitiesCommon;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ConstructionDescription {

  
    private String address;
   
    private int numberOfFloors;
    private int numberOfUnits; // For apartments, mall stores, or warehouse sections
    private String constructionMaterial; // Concrete, steel, wood, etc.
    private boolean parkingAvailable;
    private int yearBuilt;
    private String description;	
}
