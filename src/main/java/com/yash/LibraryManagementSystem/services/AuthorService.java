package com.yash.LibraryManagementSystem.services;

import com.yash.LibraryManagementSystem.daos.AuthorRepository;
import com.yash.LibraryManagementSystem.models.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;
    public Author checkOrCreate(Author author) {
        Author retrivedAuthor = authorRepository.findByEmail(author.getEmail());
        if(retrivedAuthor == null) {
            // You don't have the author present in DB
            authorRepository.save(author);
            return author;
        }
        return retrivedAuthor;
    }
}
