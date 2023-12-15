package com.yash.LibraryManagementSystem.services;

import com.yash.LibraryManagementSystem.daos.AdminRepository;
import com.yash.LibraryManagementSystem.models.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AdminService {
    @Autowired
    AdminRepository adminRepository;
    public Admin find(int id) {
        Optional<Admin> admin = adminRepository.findById(id);
        return admin.orElse(null);
    }
}
