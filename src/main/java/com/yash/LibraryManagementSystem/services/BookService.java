package com.yash.LibraryManagementSystem.services;

import com.yash.LibraryManagementSystem.daos.BookRepository;
import com.yash.LibraryManagementSystem.models.Author;
import com.yash.LibraryManagementSystem.models.Book;
import com.yash.LibraryManagementSystem.models.Genre;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;

    @Autowired
    AuthorService authorService;

    @Transactional
    public void create(Book book) {

        Author author = book.getMyAuthor();
        Author foundAuthor = authorService.checkOrCreate(author);

        //Set author to latest author
        book.setMyAuthor(foundAuthor);
        bookRepository.save(book);

        // YOU HAVE CREATED A NEW AUTHOR OBJECT
        // IF WE ARE CREATING A BOOK

        // FIRST STORE THE AUTHOR INTO DB
        //  -> IF AUTHOR ALREADY EXISTS DON'T ADD THE AUTHOR

        // THEN STORE BOOK INTO DB

        // CHECK IF THE AUTHOR EXISTS OR NOT ?
        // WE NEED AN AUTHOR SERVICE AND AUTHOR REPO TO REPORT THIS TO US

        // WE ARE ABLE TO USE AUTHOR REPO IN THE BOOK SERVICE BUT IT IS
        // NOT RECOMMENDED TO USE TWO REPO IN THE SAME SERVICE
    }

    public List<Book> getAllBooks(String key, String value) throws Exception {
        switch (key) {
            case "id": {
                Optional<Book> book = bookRepository.findById(Integer.parseInt(value));
                if(book.isPresent()) {
                    return List.of(book.get());
                }else {
                    return new ArrayList<>();
                }
            }
            case "genre": {
                return bookRepository.findByGenre(Genre.valueOf(value));
            }
            case "authorName": {

            }
            case "name": {
                return bookRepository.findByName(value);
            }
            default:
                throw new Exception("Search key doesn't present");
        }

    }
}
