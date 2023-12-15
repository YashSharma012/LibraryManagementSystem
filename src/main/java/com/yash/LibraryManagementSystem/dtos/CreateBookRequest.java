package com.yash.LibraryManagementSystem.dtos;

import com.yash.LibraryManagementSystem.models.Author;
import com.yash.LibraryManagementSystem.models.Book;
import com.yash.LibraryManagementSystem.models.Genre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateBookRequest {
    @NotBlank
    private String name;

    @NotNull    //not-blank can't be used in user defined types
    private Genre genre;

    @NotBlank
    private String authorName;

    @NotBlank
    private String authorEmail;

    public Book toBook(){
        return Book.builder()
                .name(name)
                .genre(genre)
                .myAuthor(Author.builder().name(authorName).email(authorEmail).build())
                .build();
    }
}
