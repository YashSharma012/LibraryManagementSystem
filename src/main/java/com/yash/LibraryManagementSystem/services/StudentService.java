package com.yash.LibraryManagementSystem.services;

import com.yash.LibraryManagementSystem.daos.StudentRepository;
import com.yash.LibraryManagementSystem.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentService{
    @Autowired
    StudentRepository studentRepository;
    public void create(Student student) {
        studentRepository.save(student);
    }
    public Student find(int id) {
        Optional<Student> student = studentRepository.findById(id);
        return student.orElse(null);
    }
}
