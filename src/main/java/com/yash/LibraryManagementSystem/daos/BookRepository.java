package com.yash.LibraryManagementSystem.daos;

import com.yash.LibraryManagementSystem.models.Book;
import com.yash.LibraryManagementSystem.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByGenre(Genre genre);
    List<Book> findByName(String name);
}
