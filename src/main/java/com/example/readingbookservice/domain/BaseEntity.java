package com.example.readingbookservice.domain;


import lombok.Data;

import javax.persistence.*;

@Data
public class BaseEntity {

//    private final static long SERIAL_NUMBER = 13123123123123131L;

    @Column(name = "created_at")
    private long created_at;

    @Column(name = "updated_at")
    private long updated_at;
}
