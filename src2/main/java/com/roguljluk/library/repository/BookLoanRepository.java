package com.roguljluk.library.repository;

import com.roguljluk.library.model.BookLoan;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookLoanRepository extends JpaRepository<BookLoan, Long> {
    List<BookLoan> findAllByUserIdAndBookId(Long userId, Long bookId, Sort sort);
    BookLoan findTopByUserIdAndBookId(Long userId, Long bookId, Sort sort);
    List<BookLoan> findAllByUserId(Long userId);
}
