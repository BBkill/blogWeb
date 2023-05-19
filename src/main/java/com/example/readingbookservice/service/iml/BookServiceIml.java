package com.example.readingbookservice.service.iml;

import com.example.readingbookservice.domain.Author;
import com.example.readingbookservice.domain.Book;
import com.example.readingbookservice.domain.Category;
import com.example.readingbookservice.dto.req.AddNewBookReqDto;
import com.example.readingbookservice.repo.AuthorRepo;
import com.example.readingbookservice.repo.BookRepo;
import com.example.readingbookservice.repo.CategoryRepo;
import com.example.readingbookservice.service.BookService;
import com.example.readingbookservice.util.FileUtil;
import com.example.readingbookservice.util.Result;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.*;

@Service
@AllArgsConstructor
public class BookServiceIml implements BookService {

    private final BookRepo bookRepo;
    private final AuthorRepo authorRepo;
    private final CategoryRepo categoryRepo;
    private final ModelMapper mapper;

//    @Value("${path.save.file}")
    private final String DOMAIN = "D:/2023-2024/webDung/btl/front";
    private final String PATH_SAVE_FILE = DOMAIN + "/my-app/public/img/";
    private final String PATH_SPLIT = DOMAIN + "/my-app/public";

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
        List<Author> authorSet = new ArrayList<>();
        if (StringUtils.hasLength(dto.getCategories())) {
            String[] cate = dto.getCategories().split(",");
            for (String item: cate) {
                Optional<Category> category = categoryRepo.findByNameLike(item);
                category.ifPresentOrElse(categorySet::add, () -> {
                    Category tmp = new Category();
                    tmp.setName(item);
                    categorySet.add(tmp);
                });
            }
        }

        if (StringUtils.hasLength(dto.getAuthors())) {
            String[] authors = dto.getAuthors().split(",");
            for (String item: authors) {
                Optional<Author> author = authorRepo.findByNameLike(item);
                author.ifPresentOrElse(authorSet::add, () -> {
                    Author tmp = new Author();
                    tmp.setName(item);
                    authorSet.add(tmp);
                });
            }
        }

        mapper.map(dto, book);
        List<Category> categories = categoryRepo.saveAll(categorySet);
        List<Author> authors = authorRepo.saveAll(authorSet);
        book.setCategories(categories);
        book.setAuthors(authors);
        if (!(book.getId() != null && book.getId() != 0)) {
            book = bookRepo.save(book);
        }
        setPathImg(book, dto.getImgBase64());
        return Result.success(bookRepo.save(book));
    }

    private void setPathImg(Book book, String base64) {
        if (StringUtils.hasLength(base64)) {
            String path = PATH_SAVE_FILE.concat(book.getId()+"").concat(".png");
            if (FileUtil.convertAndSave(base64, path)){
                System.out.println("save file success, path: " + path);
                path = path.replace(PATH_SPLIT, "");
                book.setPathImg(path);
            } else {
                System.out.println("save file fail");
            }
        }
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
