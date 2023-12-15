package com.yash.LibraryManagementSystem.controllers;

import com.yash.LibraryManagementSystem.dtos.CreateBookRequest;
import com.yash.LibraryManagementSystem.models.Book;
import com.yash.LibraryManagementSystem.services.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/book")
    public void addBook(@RequestBody @Valid CreateBookRequest createBookRequest){
        bookService.create(createBookRequest.toBook());
    }

    @GetMapping("/searchBook")
    //get books filtered by genre
    //get books by author
    //these scenarios are often seen
    // So you pass key value pairs
    // e.g., key - genre
    //       value - fictional
    public List<Book> getBooks(@RequestParam("key") String key, @RequestParam("value") String value) throws Exception {
        return bookService.getAllBooks(key, value);
    }
}
