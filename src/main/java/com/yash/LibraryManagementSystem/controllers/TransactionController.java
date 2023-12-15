package com.yash.LibraryManagementSystem.controllers;

import com.yash.LibraryManagementSystem.dtos.InitiateTransactionRequest;
import com.yash.LibraryManagementSystem.services.TransactionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/transaction")
    public String initiateTransaction(@RequestBody @Valid InitiateTransactionRequest initiateTransactionRequest) {
        transactionService.handleTxn(initiateTransactionRequest);
    }
}
