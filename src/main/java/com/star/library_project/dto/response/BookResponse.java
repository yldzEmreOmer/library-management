package com.star.library_project.dto.response;

import java.time.LocalDate;

import com.star.library_project.model.BookStatus;
import com.star.library_project.model.Genre;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookResponse {

    private Long id;

    private String title;

    private String author;

    private String isbn;

    private LocalDate publicationDate;

    private BookStatus status;

    private Genre genre;

    private String description;

    private String imageUrl;

    private int quantity;

    private int availableQuantity;
}
