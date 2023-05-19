package com.example.readingbookservice.dto.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

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
