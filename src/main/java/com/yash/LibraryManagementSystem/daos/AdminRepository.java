package com.yash.LibraryManagementSystem.daos;

import com.yash.LibraryManagementSystem.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
