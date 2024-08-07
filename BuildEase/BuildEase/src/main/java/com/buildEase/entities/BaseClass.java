package com.buildEase.entities;

import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@MappedSuperclass
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Size(min = 10)
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String username;

    @NotNull
    @Size(min = 10)
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[!@#\\$%\\^&\\*])")
    private String password;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String firstName;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String lastName;

    @NotNull
    private LocalDate birthdate;

    @NotNull
    private String gender;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    private String phone;

    @NotNull
    private Address address;

    @NotNull
    private String role;
    
    
    
}