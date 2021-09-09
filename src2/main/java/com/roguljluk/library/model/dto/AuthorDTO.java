package com.roguljluk.library.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class AuthorDTO {
    private Long id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
}
