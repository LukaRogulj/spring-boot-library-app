package com.roguljluk.library.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorCreationDTO {
    @NotNull(message = "Author first name cannot be null")
    public String firstName;
    @NotNull(message = "Author last name cannot be null")
    public String lastName;
}
