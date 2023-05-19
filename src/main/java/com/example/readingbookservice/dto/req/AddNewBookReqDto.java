package com.example.readingbookservice.dto.req;

import com.example.readingbookservice.domain.Author;
import com.example.readingbookservice.domain.Category;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AddNewBookReqDto {

    private Long id;

    private String name;

    private String description;

    private Long released;

    private Long totalPages;

    @JsonProperty(value = "authorsArr")
    private String authors;

    @JsonProperty(value = "categoriesArr")
    private String categories;

    private String imgBase64;
}
