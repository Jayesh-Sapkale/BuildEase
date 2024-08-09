package com.buildEase.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Address {
    private String city;

    private String pincode;

    private String state;

    private String addressLine1;
}
