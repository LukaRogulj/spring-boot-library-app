package com.roguljluk.library.util.mapper;

import com.roguljluk.library.model.Author;
import com.roguljluk.library.model.dto.AuthorCreationDTO;
import com.roguljluk.library.model.dto.AuthorDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorMapper {
    AuthorDTO authorToAuthorDTO(Author author);
    Author authorDTOToAuthor(AuthorDTO authorDTO);
    Author authorCreationDTOToAuthor(AuthorCreationDTO authorCreationDTO);
    List<AuthorDTO> authorsToAuthorDTOs(List<Author> authors);
}
