package com.example.readingbookservice.repo;

import com.example.readingbookservice.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthorRepo extends JpaRepository<Author, Long> {
    Optional<Author> findByNameLike(String name);
}
