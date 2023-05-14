package com.example.readingbookservice.service;

import com.example.readingbookservice.domain.Book;
import com.example.readingbookservice.domain.Category;
import com.example.readingbookservice.dto.req.AddNewBookReqDto;
import com.example.readingbookservice.util.Result;

import java.util.List;

public interface BookService {

    List<Category> getAllCategories();

    List<Book> getAllBook(int start, int limit);

    Book getBook(long id);

    Result<Book> addNewBook(AddNewBookReqDto book);

    Result<Category> addNewCategory(Category book);

    Result<Book> editBook(AddNewBookReqDto book);

    Result<Book> deleteBook(Long id);
}
