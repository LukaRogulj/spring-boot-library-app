package com.roguljluk.library.model.dto;

import com.roguljluk.library.model.Author;
import com.roguljluk.library.model.BookLoan;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class BookDTO {
    private Long id;
    private String ISBN;
    private String title;
    private Set<Author> authors;
    private Integer year;
    private String note;
    private Set<BookLoan> loans;
}
