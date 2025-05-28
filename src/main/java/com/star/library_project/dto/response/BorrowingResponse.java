package com.star.library_project.dto.response;

import java.time.LocalDate;

import com.star.library_project.model.BorrowingStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BorrowingResponse {

    private Long id;

    private DtoUserResponse user;

    private BookResponse book;

    private LocalDate borrowingDate;

    private LocalDate returnDate;

    private LocalDate dueDate;

    private BorrowingStatus status;

    private boolean isLate;

    private int daysOverdue;

    private Long version;
}