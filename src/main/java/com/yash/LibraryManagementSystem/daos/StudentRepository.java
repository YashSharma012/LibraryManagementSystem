package com.yash.LibraryManagementSystem.daos;

import com.yash.LibraryManagementSystem.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student,Integer> {

}
