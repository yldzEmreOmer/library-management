package com.star.library_project.service.impl;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.star.library_project.dto.DtoUser;
import com.star.library_project.exception.BaseException;
import com.star.library_project.exception.ErrorMessage;
import com.star.library_project.exception.MessageType;
import com.star.library_project.jwt.AuthRequest;
import com.star.library_project.jwt.AuthResponse;
import com.star.library_project.jwt.JwtService;
import com.star.library_project.model.RefreshToken;
import com.star.library_project.model.Role;
import com.star.library_project.model.User;
import com.star.library_project.reporistory.RefreshTokenRepository;
import com.star.library_project.reporistory.UserRepository;
import com.star.library_project.service.IAuthenticationService;

@Service
public class AuthenticationServiceImpl implements IAuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtService jwtService;

    @Autowired
    private RefreshTokenRepository refreshTokenRepository;

    private User createUser(AuthRequest input) {
        User user = new User();
        user.setUsername(input.getUsername());
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

    private RefreshToken createRefreshToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setCreateTime(new Date());
        refreshToken.setExpiredDate(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 4));
        refreshToken.setRefreshToken(UUID.randomUUID().toString());
        refreshToken.setUser(user);
        return refreshToken;
    }

    @Override
    public AuthResponse authenticate(AuthRequest input) {
        try {
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    input.getUsername(), input.getPassword());
            authenticationProvider.authenticate(authenticationToken);

            Optional<User> optUser = userRepository.findByUsername(input.getUsername());

            String accessToken = jwtService.generateToken(optUser.get());
            RefreshToken savedRefreshToken = refreshTokenRepository.save(createRefreshToken(optUser.get()));

            return new AuthResponse(accessToken, savedRefreshToken.getRefreshToken());
        } catch (Exception e) {
            throw new BaseException(new ErrorMessage(MessageType.USERNAME_OR_PASSWORD_INVALID, e.getMessage()));
        }
    }

}
