package com.star.library_project.service;

import java.util.List;

import com.star.library_project.dto.request.BookRequest;
import com.star.library_project.dto.response.BookResponse;

public interface IBookService {

    public BookResponse createBook(BookRequest input);

    public BookResponse updateBook(BookRequest input);

    public BookResponse getBookById(Long id);

    public List<BookResponse> getAllBooks();

    public void deleteBook(Long id);

    public List<BookResponse> getBooksByAuthor(String author);

    public List<BookResponse> getBooksByTitle(String title);

    public List<BookResponse> getBooksByCategory(String category);

}
