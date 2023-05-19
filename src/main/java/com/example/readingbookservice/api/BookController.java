package com.example.readingbookservice.api;

import com.example.readingbookservice.domain.Book;
import com.example.readingbookservice.domain.Category;
import com.example.readingbookservice.dto.req.AddNewBookReqDto;
import com.example.readingbookservice.dto.req.DeleteBookReq;
import com.example.readingbookservice.service.BookService;
import com.example.readingbookservice.util.JsonUtil;
import com.example.readingbookservice.util.Result;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book")
@AllArgsConstructor
@CrossOrigin
public class BookController {

    private final BookService bookService;

    @GetMapping("/all-books")
    public ResponseEntity<Result<List<Book>>> getAllBooks(
            @RequestParam(required = false, defaultValue = "0") int start,
            @RequestParam(required = false, defaultValue = "99") int limit) {
        return ResponseEntity.ok(Result.success(bookService.getAllBook(start, limit)));
    }

    @GetMapping("/all-categories")
    public ResponseEntity<Result<List<Category>>> getAllCategories(
            @RequestParam(required = false, defaultValue = "0") int start,
            @RequestParam(required = false, defaultValue = "99") int limit) {
        return ResponseEntity.ok(Result.success(bookService.getAllCategories()));
    }

    @GetMapping("/book")
    public ResponseEntity<Result<Book>> getBookDetail(@RequestParam(name = "id") long id) {
        return ResponseEntity.ok(Result.success(bookService.getBook(id)));
    }

    @PostMapping("/add-book")
    public ResponseEntity<Result<Book>> addNewBook(@RequestBody AddNewBookReqDto book) {
        System.out.println(JsonUtil.toJSONString(book));
        HttpHeaders httpHeaders = new HttpHeaders();
//        return ResponseEntity.ok(bookService.addNewBook(book));
        return ResponseEntity.ok(Result.success());
    }

    @PostMapping("/update-book")
    public ResponseEntity<Result<Book>> updateBook(@RequestBody AddNewBookReqDto book) {
        System.out.println("add book___" + JsonUtil.toJSONString(book));
//        return ResponseEntity.ok(Result.success());
        return ResponseEntity.ok(bookService.editBook(book));
    }

    @PostMapping("/delete-book")
    public ResponseEntity<Result<Book>> deleteBook(@RequestBody DeleteBookReq req) {
        return ResponseEntity.ok(bookService.deleteBook(req.getId()));
    }

}
