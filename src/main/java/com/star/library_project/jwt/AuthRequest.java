package com.star.library_project.jwt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {

    @NotEmpty(message = "email cannot be empty")
    @Email(message = "email must be a valid email address")
    private String email;

    @NotEmpty(message = "password cannot be empty")
    private String password;
}
