package com.example.readingbookservice.repo;

import com.example.readingbookservice.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByEmailOrUsername(String email, String username);

    boolean existsUserByEmail(String email);

    boolean existsUserByUsername(String username);
}
