package com.example.readingbookservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public enum Gender {
    MALE(0, "nam"),
    FEMALE(1, "nu"),
    OTHER(2, "khac");

    private int code;

    private String desc;
}
