package com.yash.LibraryManagementSystem.services;

import com.yash.LibraryManagementSystem.daos.StudentRepository;
import com.yash.LibraryManagementSystem.daos.TransactionRepository;
import com.yash.LibraryManagementSystem.dtos.InitiateTransactionRequest;
import com.yash.LibraryManagementSystem.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TransactionService {
    @Autowired
    StudentService studentService;

    @Autowired
    AdminService adminService;

    @Autowired
    BookService bookService;

    @Autowired
    TransactionRepository transactionRepository;

    @Value("${student.max.book.allowed")
    private int bookLimit;


    public String handleTxn(InitiateTransactionRequest txnRequest) {
        if(txnRequest.getTransactionType() == TransactionType.RETURN){

        } else if (txnRequest.getTransactionType() == TransactionType.ISSUE) {

        }
        return "Hello World";
    }

    public String issueBook(InitiateTransactionRequest txnRequest) throws Exception {
        Student student = studentService.find(txnRequest.getStudentId());
        Admin admin = adminService.find(txnRequest.getAdminId());
        List<Book> bookList = bookService.getAllBooks("id", String.valueOf(txnRequest.getBookId()));

        Book book = bookList.get(0);
        if(student == null || book == null || book.getStudent() != null || admin == null || student.getBookList().size() > bookLimit) {
            throw new Exception("Action is Invalid, Can't issue the book");
        }

        //Everything is fine
        Transaction transaction = Transaction.builder()
                .txnId(UUID.randomUUID().toString())
                .student(student)
                .book(book)
                .transactionType(txnRequest.getTransactionType())
                .build();
        transactionRepository.save(transaction);
        return "Hello World"; 
    }
}
