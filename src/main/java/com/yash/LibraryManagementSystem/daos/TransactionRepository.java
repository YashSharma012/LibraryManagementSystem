package com.yash.LibraryManagementSystem.daos;

import com.yash.LibraryManagementSystem.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction,Integer> {
}
