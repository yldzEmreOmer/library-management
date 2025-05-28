package com.star.library_project.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import com.star.library_project.model.Borrowing;
import com.star.library_project.model.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DtoUserResponse {

    private Long id;

    private LocalDateTime createdAt;

    private String username;

    private String email;

    private Role role;

    private List<Borrowing> borrowings;
}
