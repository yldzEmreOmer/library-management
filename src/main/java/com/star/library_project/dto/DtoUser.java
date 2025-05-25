package com.star.library_project.dto;

import com.star.library_project.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser {

    private Long id;
    private String name;

    private String email;

    private String password;

    private Role role;
}
