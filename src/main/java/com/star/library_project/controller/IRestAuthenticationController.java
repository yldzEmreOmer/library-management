package com.star.library_project.controller;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

}
