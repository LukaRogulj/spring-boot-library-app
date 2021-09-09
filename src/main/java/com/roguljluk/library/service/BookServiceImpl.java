package com.roguljluk.library.service;

import com.roguljluk.library.model.Book;
import com.roguljluk.library.model.dto.BookCreationDTO;
import com.roguljluk.library.model.dto.BookDTO;
import com.roguljluk.library.repository.BookRepository;
import com.roguljluk.library.service.api.BookService;
import com.roguljluk.library.util.mapper.BookMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }


    @Override
    public BookDTO createNewBook(BookCreationDTO bookCreationDTO) {

        Book book = bookMapper.bookCreationDTOToBook(bookCreationDTO);
        bookRepository.save(book);

        return bookMapper.bookToBookDTO(book);
    }

    @Override
    public BookDTO getBook(Long bookId) {
        return bookMapper.bookToBookDTO(bookRepository.getById(bookId));
    }

    @Override
    public BookDTO getBookByISBN(String ISBN) {
        Book book = bookRepository.findByISBN(ISBN);
        return bookMapper.bookToBookDTO(bookRepository.findByISBN(ISBN));
    }

    @Override
    public List<BookDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return bookMapper.booksToBookDTOs(books);
    }

    @Override
    public BookDTO updateBook(Long bookId, BookDTO bookDTO) {
        Book book = bookRepository.findById(bookId).orElse(null);
        book.setAuthors(bookDTO.getAuthors());
        book.setISBN(bookDTO.getISBN());
        book.setNote(bookDTO.getNote());
        book.setTitle(bookDTO.getTitle());
        book.setYear(bookDTO.getYear());

        bookRepository.save(book);

        return bookMapper.bookToBookDTO(book);
    }

    @Override
    public void deleteBook(Long bookId) {
        bookRepository.deleteById(bookId);
    }

    @Override
    public void deleteBookByISBN(String bookISBN) {
        bookRepository.deleteByISBN(bookISBN);
    }
}
