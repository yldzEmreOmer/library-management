package com.star.library_project.dto.request;

import java.time.LocalDate;

import com.star.library_project.model.BorrowingStatus;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowingRequest {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Book ID cannot be null")
    private Long bookId;

    @NotNull(message = "Due date cannot be null")
    private LocalDate dueDate;

    @NotNull(message = "Status cannot be null")
    private BorrowingStatus status;
}