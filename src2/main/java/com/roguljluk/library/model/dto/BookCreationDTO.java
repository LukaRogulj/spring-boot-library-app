package com.roguljluk.library.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookCreationDTO {
    private String ISBN;
    private String title;
    private Long authorId;
    private Integer year;
    private String note;
}
