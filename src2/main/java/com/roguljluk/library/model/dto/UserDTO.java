package com.roguljluk.library.model.dto;

import com.roguljluk.library.model.BookLoan;
import com.roguljluk.library.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private Set<BookLoan> loanedBooks;

}
