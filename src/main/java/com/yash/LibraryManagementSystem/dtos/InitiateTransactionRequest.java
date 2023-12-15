package com.yash.LibraryManagementSystem.dtos;

import com.yash.LibraryManagementSystem.models.TransactionType;
import lombok.Builder;
import lombok.Data;

@Data
public class InitiateTransactionRequest {
    private Integer adminId;
    private Integer studentId;
    private Integer bookId;
    private TransactionType transactionType;
}

