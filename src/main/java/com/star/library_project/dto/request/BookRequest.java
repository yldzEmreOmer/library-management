package com.star.library_project.dto.request;

import java.time.LocalDate;

import com.star.library_project.model.BookStatus;
import com.star.library_project.model.Genre;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookRequest {

    @NotBlank
    @Size(min = 1, max = 255)
    private String title;

    @NotBlank
    @Size(min = 1, max = 255)
    private String author;

    @NotBlank
    @Size(min = 10, max = 13)
    private String isbn;

    @NotNull
    private LocalDate publicationDate;

    @NotNull
    private BookStatus status;

    @NotNull
    private Genre genre;

    @Size(max = 1000)
    private String description;

    private String imageUrl;

    @Min(0)
    private int quantity;

    @Min(0)
    private int availableQuantity;
}
