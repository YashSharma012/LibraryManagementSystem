package com.yash.LibraryManagementSystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @Enumerated
    private Genre genre;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @JoinColumn
    @ManyToOne
    @JsonIgnoreProperties("bookList")
    private Author myAuthor;

    @JoinColumn //if you don't specify the column then it will take id as default
    @ManyToOne
    private Student student;

    @OneToMany(mappedBy = "book")
    private List<Transaction> transactionList;
}
