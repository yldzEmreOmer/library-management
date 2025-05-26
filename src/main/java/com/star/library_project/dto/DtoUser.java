package com.star.library_project.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.star.library_project.model.Borrowing;
import com.star.library_project.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUser {

    private Long id;

    private String username;

    private String email;

    private String password;

    private Role role;

    private List<Borrowing> borrowings;

    private LocalDateTime createdAt;
}
