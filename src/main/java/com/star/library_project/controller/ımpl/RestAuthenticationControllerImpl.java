package com.star.library_project.controller.ımpl;

import org.springframework.web.bind.annotation.RestController;

import com.star.library_project.controller.IRestAuthenticationController;
import com.star.library_project.controller.RestBaseController;
import com.star.library_project.controller.RootEntity;
import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;
import com.star.library_project.jwt.RefreshTokenRequest;
import com.star.library_project.service.IAuthenticationService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class RestAuthenticationControllerImpl extends RestBaseController implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }

}
