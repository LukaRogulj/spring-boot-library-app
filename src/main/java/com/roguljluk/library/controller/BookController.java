package com.roguljluk.library.controller;

import com.roguljluk.library.model.BookLoan;
import com.roguljluk.library.model.dto.BookDTO;
import com.roguljluk.library.repository.BookRepository;
import com.roguljluk.library.service.api.BookLoanService;
import com.roguljluk.library.service.api.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;
    private final BookLoanService loanService;

    public BookController(BookService bookService, BookLoanService loanService) {
        this.bookService = bookService;
        this.loanService = loanService;
    }

    @RequestMapping("/")
    public String getBooks(Model model){
        List<BookDTO> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books";
    }
}
