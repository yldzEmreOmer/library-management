package com.star.library_project.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.model.Role;
import com.star.library_project.model.User;
import com.star.library_project.reporistory.UserRepository;
import com.star.library_project.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setEmail(input.getEmail());
        user.setPassword(passwordEncoder.encode(input.getPassword()));
        user.setRole(Role.MEMBER);
        return user;
    }

    @Override
    public DtoUser register(AuthRequest input) {
        User savedUser = userRepository.save(createUser(input));
        DtoUser dtoUser = new DtoUser();
        BeanUtils.copyProperties(savedUser, dtoUser);
        return dtoUser;

    }

}
