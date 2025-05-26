package com.star.library_project.service;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);
}
