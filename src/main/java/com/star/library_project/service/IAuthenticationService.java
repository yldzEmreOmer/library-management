package com.star.library_project.service;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;
import com.star.library_project.jwt.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);
}
