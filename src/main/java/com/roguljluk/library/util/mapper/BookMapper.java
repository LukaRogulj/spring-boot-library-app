package com.roguljluk.library.util.mapper;

import com.roguljluk.library.model.Book;
import com.roguljluk.library.model.dto.BookCreationDTO;
import com.roguljluk.library.model.dto.BookDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookMapper {
    BookDTO bookToBookDTO(Book book);
    Book bookDTOToBook(BookDTO bookDTO);
    Book bookCreationDTOToBook(BookCreationDTO bookCreationDTO);
    List<BookDTO> booksToBookDTOs(List<Book> books);
}
