package com.example.readingbookservice.service.iml;

import com.example.readingbookservice.domain.Book;
import com.example.readingbookservice.domain.Category;
import com.example.readingbookservice.dto.req.AddNewBookReqDto;
import com.example.readingbookservice.repo.AuthorRepo;
import com.example.readingbookservice.repo.BookRepo;
import com.example.readingbookservice.repo.CategoryRepo;
import com.example.readingbookservice.service.BookService;
import com.example.readingbookservice.util.Result;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@AllArgsConstructor
public class BookServiceIml implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper mapper;

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    @Override
    public List<Book> getAllBook(int start, int limit) {
        Pageable pageable = PageRequest.of(start, limit);
        return bookRepo.findAll(pageable).getContent();
    }

    @Override
    public Book getBook(long id) {
        Optional<Book> book = bookRepo.findById(id);
        return book.orElseGet(Book::new);
    }

    @Override
    public Result<Book> addNewBook(AddNewBookReqDto dto) {
        Book book = new Book();
        List<Category> categorySet = new ArrayList<>();
        if (!CollectionUtils.isEmpty(dto.getCategories())) {
            dto.getCategories().forEach(item -> {
                categorySet.add(initCategory(item.getId(), item.getName()));
            });
        }
        mapper.map(dto, book);
        List<Category> categories = categoryRepo.saveAll(categorySet);
        book.setCategories(new ArrayList<>(categories));
        return Result.success(bookRepo.save(book));
    }

    private Category initCategory(Long id, String name) {
        Category category = new Category();
        if (id != null) {
            category.setId(id);
            category.setUpdated_at(System.currentTimeMillis());
        }
        category.setName(name);
        category.setCreated_at(System.currentTimeMillis());
        return category;
    }

    public Result<Category> addNewCategory(Category category) {
        return Result.success(categoryRepo.save(category));
    }

    @Override
    public Result<Book> editBook(AddNewBookReqDto book) {
        return addNewBook(book);
    }

    @Override
    public Result<Book> deleteBook(Long id) {
        bookRepo.deleteById(id);
        return Result.success();
    }
}
