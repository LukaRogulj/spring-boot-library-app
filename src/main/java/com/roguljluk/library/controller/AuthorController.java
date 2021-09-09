package com.roguljluk.library.controller;

import com.roguljluk.library.repository.AuthorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/author")
public class AuthorController {

    private final AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @RequestMapping("/")
    public String getAuthors(Model model){

        model.addAttribute("authors", authorRepository.findAll());
        return "authors";
    }
}
