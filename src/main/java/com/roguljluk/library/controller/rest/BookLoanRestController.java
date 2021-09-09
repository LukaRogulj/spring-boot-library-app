package com.roguljluk.library.controller.rest;

import com.roguljluk.library.model.BookLoan;
import com.roguljluk.library.service.api.BookLoanService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/book-loan")
public class BookLoanRestController {

    private final BookLoanService loanService;

    public BookLoanRestController(BookLoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<BookLoan>> getAllLoansFromUser(@PathVariable Long id){
        return ResponseEntity.ok(loanService.getAllLoansFromUser(id));
    }

    @PostMapping("/loan/{bookId}/{userId}")
    public ResponseEntity<BookLoan> loanBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return ResponseEntity.ok(loanService.loanBook(userId, bookId, ""));
    }

    @PostMapping("/return/{bookId}/{userId}")
    public ResponseEntity<BookLoan> returnBook(@PathVariable Long userId, @PathVariable Long bookId) {
        return ResponseEntity.ok(loanService.returnBook(userId, bookId));
    }
}
