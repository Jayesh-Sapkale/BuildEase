package com.buildEase.dtos;

import java.time.LocalDate;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseClassDto {
    

    @NotNull
    @Size(min = 10)
    private String username;

    @NotNull
    @Size(min = 10)
    private String password;

    @NotNull
    private String firstName;

    @NotNull
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
    private String address;

    @NotNull
    private String role;
}

