package com.roguljluk.library.service;

import com.roguljluk.library.exception.AuthorCreationException;
import com.roguljluk.library.model.Author;
import com.roguljluk.library.model.dto.AuthorCreationDTO;
import com.roguljluk.library.model.dto.AuthorDTO;
import com.roguljluk.library.repository.AuthorRepository;
import com.roguljluk.library.service.api.AuthorService;
import com.roguljluk.library.service.api.BookService;
import com.roguljluk.library.util.mapper.AuthorMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class AuthorServiceImpl implements AuthorService {

    private final BookService bookService;
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public AuthorServiceImpl(BookService bookService, AuthorRepository authorRepository, AuthorMapper authorMapper) {
        this.bookService = bookService;
        this.authorRepository = authorRepository;
        this.authorMapper = authorMapper;
    }

    @Override
    public AuthorDTO createNewAuthor(AuthorCreationDTO authorCreationDTO) {
        log.debug("createNewAuthor()");
        if (authorCreationDTO.getFirstName().isEmpty() && authorCreationDTO.getLastName().isEmpty()) {
            log.error("error creating new Author - needs to have at least first name or last name");
            throw new AuthorCreationException("Author needs to have at least first name or last name");
        }
        Author author = authorMapper.authorCreationDTOToAuthor(authorCreationDTO);
        authorRepository.save(author);

        return authorMapper.authorToAuthorDTO(author);
    }

    @Override
    public AuthorDTO getAuthor(Long authorId) {
        log.debug("getAuthor()");
        Author author = authorRepository.findById(authorId).orElse(null);
        return authorMapper.authorToAuthorDTO(author);
    }

    @Override
    public List<AuthorDTO> getAllAuthors() {
        log.debug("getAllAuthors()");
        List<Author> authors = authorRepository.findAll();

        List<AuthorDTO> authorDTOS = authorMapper.authorsToAuthorDTOs(authors);

        return authorDTOS;
    }

    @Override
    public AuthorDTO updateAuthor(Long authorId, AuthorDTO authorDTO) {
        log.debug("updateAuthor()");
        Author author = authorRepository.findById(authorId).orElse(null);

        author.setFirstName(authorDTO.getFirstName());
        author.setLastName(authorDTO.getLastName());

        return authorMapper.authorToAuthorDTO(authorRepository.save(author));
    }

    @Override
    public void deleteAuthor(Long authorId) {
        log.debug("deleteAuthor()");
        authorRepository.deleteById(authorId);
    }
}
