package com.yash.LibraryManagementSystem.controllers;

import com.yash.LibraryManagementSystem.dtos.CreateStudentRequest;
import com.yash.LibraryManagementSystem.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping("/student")
    public void createStudent(@RequestBody @Valid CreateStudentRequest createStudentRequest) {
        studentService.create(createStudentRequest.toStudent());
    }
}
