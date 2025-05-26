package com.star.library_project.controller;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

}
