package com.yash.LibraryManagementSystem.dtos;

import com.yash.LibraryManagementSystem.models.Student;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateStudentRequest {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @Min(10)
    @Max(20)
    private int age;

    public Student toStudent() {
        return Student.builder()
                .name(name)
                .age(age)
                .email(email)
                .build();
    }
}
