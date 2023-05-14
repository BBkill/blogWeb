package com.example.readingbookservice.domain;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
public class BaseEntity {

//    private final static long SERIAL_NUMBER = 13123123123123131L;

    @Column(name = "created_at")
    private long created_at;

    @Column(name = "updated_at")
    private long updated_at;
}
