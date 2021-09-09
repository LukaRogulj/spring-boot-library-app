package com.roguljluk.library.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class BookLoan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @Column
    @NotNull(message = "Loan date cannot be null")
    private Date loanTime;

    @Column
    private Date returnedTime;

    @Column
    private String note;

    public BookLoan(User user, Book book, @NotNull(message = "Loan date cannot be null") Date loanTime, String note) {
        this.user = user;
        this.book = book;
        this.loanTime = loanTime;
        this.note = note;
    }
}
