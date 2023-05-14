package com.example.readingbookservice.dto.req;

import com.example.readingbookservice.domain.Author;
import com.example.readingbookservice.domain.Category;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
public class AddNewBookReqDto {
    private String name;

    private String description;

    private Long released;

    private Long totalPages;

    private List<AuthorDto> authors;

    private List<CategoryDto> categories;
}
