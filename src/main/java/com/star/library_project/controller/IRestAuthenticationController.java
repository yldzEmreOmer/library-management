package com.star.library_project.controller;

import com.star.library_project.dto.request.DtoUserRequest;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;
import com.star.library_project.jwt.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUserRequest> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);

}
