package com.star.library_project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Size(max = 1000)
    private String description;

    private String imageUrl;

    @Min(0)
    private int quantity;

    @Min(0)
    private int availableQuantity;

}
