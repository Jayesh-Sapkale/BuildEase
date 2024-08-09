package com.construction.dtos;



import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuilderReviewDTO {

    private Integer reviewId;
    private Integer customerId; // Reference to customer by ID
    private Integer rating;
    private String review;
    private LocalDate reviewDate;
    private Integer builderId; // Reference to builder by ID

   
}

