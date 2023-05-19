package com.example.readingbookservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ReadingBookServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReadingBookServiceApplication.class, args);
    }

}
