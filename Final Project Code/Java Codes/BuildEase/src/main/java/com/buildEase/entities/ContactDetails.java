package com.buildEase.entities;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
public class ContactDetails {
    @NotNull
    @Size(min = 10, max = 10)
    private String phoneNumber;

    @NotNull
    @Email
    private String email;

    @NotNull
    @Pattern(regexp = "^(http|https)://.*$")
    private String website;
}
