package com.roguljluk.library.controller.rest;

import com.roguljluk.library.model.dto.BookCreationDTO;
import com.roguljluk.library.model.dto.BookDTO;
import com.roguljluk.library.service.api.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/book")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public ResponseEntity<List<BookDTO>> getAll() {
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping(value = "/")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookCreationDTO bookCreationDTO){
        return ResponseEntity.ok(bookService.createNewBook(bookCreationDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@NotNull @PathVariable Long id){
        return ResponseEntity.ok(bookService.getBook(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@NotNull @PathVariable Long id, @Valid @RequestBody BookDTO bookDTO){
        return ResponseEntity.ok(bookService.updateBook(id, bookDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@NotNull @PathVariable Long id){
        bookService.deleteBook(id);
        return ResponseEntity.ok(null);
    }
}
