package com.roguljluk.library.service.api;

import com.roguljluk.library.model.dto.AuthorCreationDTO;
import com.roguljluk.library.model.dto.AuthorDTO;

import java.util.List;

public interface AuthorService {

    AuthorDTO createNewAuthor(AuthorCreationDTO authorCreationDTO);
    AuthorDTO getAuthor(Long authorId);
    List<AuthorDTO> getAllAuthors();
    AuthorDTO updateAuthor(Long authorId, AuthorDTO authorDTO);
    void deleteAuthor(Long authorId);
}
