package com.roguljluk.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Size(min = 5, max = 15, message = "Book ISBN must be 5-15 characters")
    private String ISBN;

    @Column
    @Size(min = 1, max = 32, message = "Tittle must be 1-32 characters")
    private String title;

    @JsonIgnore
    @OneToMany(mappedBy = "book")
    private Set<BookLoan> loans = new HashSet<>();

    @Column
    @NotNull(message = "Book year is required")
    private Integer year;

    @Column
    private String note;

    @JsonIgnore
    @ManyToMany(mappedBy = "books")
    private Set<Author> authors = new HashSet<>();
}
