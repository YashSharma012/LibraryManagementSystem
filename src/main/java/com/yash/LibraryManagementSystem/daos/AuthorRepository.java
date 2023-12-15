package com.yash.LibraryManagementSystem.daos;

import com.yash.LibraryManagementSystem.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
    public Author findByEmail(String email);
}
