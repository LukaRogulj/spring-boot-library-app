package com.roguljluk.library.service.api;

import com.roguljluk.library.model.dto.BookCreationDTO;
import com.roguljluk.library.model.dto.BookDTO;

import java.util.List;

public interface BookService {

    BookDTO createNewBook(BookCreationDTO bookCreationDTO);
    BookDTO getBook(Long bookId);
    BookDTO getBookByISBN(String ISBN);
    List<BookDTO> getAllBooks();
    BookDTO updateBook(Long bookId, BookDTO bookDTO);
    void deleteBook(Long bookId);
    void deleteBookByISBN(String bookISBN);
}
