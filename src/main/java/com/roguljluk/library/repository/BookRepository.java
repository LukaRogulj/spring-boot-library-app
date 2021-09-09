package com.roguljluk.library.repository;

import com.roguljluk.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BookRepository extends JpaRepository<Book, Long> {
    Book findByISBN(String ISBN);
    void deleteByISBN(String ISBN);

}
