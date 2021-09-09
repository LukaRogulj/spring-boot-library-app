package com.roguljluk.library.service.api;

import com.roguljluk.library.model.BookLoan;

import java.util.List;

public interface BookLoanService {

    BookLoan loanBook(Long userId, Long bookId, String note);
    BookLoan returnBook(Long userId, Long bookId);
    List<BookLoan> getAllLoansFromUser(Long userId);
    boolean isBookLoanedByUser(Long userId, Long bookId);
}
