package com.roguljluk.library.service;

import com.roguljluk.library.model.Book;
import com.roguljluk.library.model.BookLoan;
import com.roguljluk.library.model.User;
import com.roguljluk.library.repository.BookRepository;
import com.roguljluk.library.repository.BookLoanRepository;
import com.roguljluk.library.repository.UserRepository;
import com.roguljluk.library.service.api.BookLoanService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class BookLoanServiceImpl implements BookLoanService {

    private final BookLoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final UserRepository userRepository;

    public BookLoanServiceImpl(BookLoanRepository loanRepository, BookRepository bookRepository, UserRepository userRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
    }


    private boolean checkIfBookExists(Long bookId){
        Optional<Book> book = bookRepository.findById(bookId);
        return book.isEmpty();
    }

    @Override
    public BookLoan loanBook(Long userId, Long bookId, String note) {
        Book book = bookRepository.findById(userId).orElse( null);
        User user = userRepository.findById(userId).orElse(null);

        BookLoan loan = new BookLoan(user, book, new Date(), note);
        book.getLoans().add(loan);
        user.getLoanedBooks().add(loan);

        loanRepository.save(loan);
        userRepository.save(user);
        bookRepository.save(book);

        return loan;
    }

    @Override
    public BookLoan returnBook(Long userId, Long bookId) {
        Book book = bookRepository.findById(userId).orElse( null);
        User user = userRepository.findById(userId).orElse(null);

        BookLoan loan = loanRepository.findTopByUserIdAndBookId(userId, bookId, Sort.by("returnedTime").ascending());
        loan.setReturnedTime(new Date());

        book.getLoans().add(loan);
        user.getLoanedBooks().add(loan);

        loanRepository.save(loan);
        userRepository.save(user);
        bookRepository.save(book);

        return loan;
    }

    @Override
    public List<BookLoan> getAllLoansFromUser(Long userId) {
        return loanRepository.findAllByUserId(userId);
    }

    @Override
    public boolean isBookLoanedByUser(Long userId, Long bookId) {
        List<BookLoan> loan = loanRepository.findAllByUserIdAndBookId(userId, bookId, Sort.by("returnedTime").ascending());

        return true;
    }

//    @Override
//    public UserBookLoan loanBook(Long userId, String bookISBN, String note) {
////        if (!checkIfBookExists(bookISBN)) {
////            throw new BookLoanException(
////                    String.format("Book with isbn %s, does not exist", bookISBN));
////        }
////
////        UserBookLoan userBookLoan = loanRepository.findTopByUserIdAndISBN(userId, bookISBN, Sort.by("returnedTime").ascending());
////        if(userBookLoan != null) {
////            if(userBookLoan.getLoanTime() != null && userBookLoan.getReturnedTime() != null) {
////                return loanRepository.save(new UserBookLoan(userId, bookISBN, note));
////            }
////            throw new BookLoanException(
////                    String.format("User with id: %s, already loaned book with isbn: %s", userId, bookISBN));
////        }
////        return loanRepository.save(new UserBookLoan(userId, bookISBN, note));
//        return new UserBookLoan();
//    }
//
//    @Override
//    public UserBookLoan returnBook(Long userId, String bookISBN) {
//        UserBookLoan userBookLoan = loanRepository.findTopByUserIdAndISBN(userId, bookISBN, Sort.by("returnedTime").ascending());
//        if(userBookLoan == null)
//            throw new BookLoanException(
//                    String.format("Book with ISBN: %s, never loaned, cannot be returned", bookISBN));
//        if(userBookLoan.getReturnedTime() != null)
//            throw new BookLoanException(
//                    String.format("Book with ISBN: %s, already returned", bookISBN));
//
//        userBookLoan.setReturnedTime(new Date());
//        return loanRepository.save(userBookLoan);
//    }
//
//    @Override
//    public List<UserBookLoan> getAllLoansFromUser(Long userId){
//        return loanRepository.findAllByUserId(userId);
//    }
}
