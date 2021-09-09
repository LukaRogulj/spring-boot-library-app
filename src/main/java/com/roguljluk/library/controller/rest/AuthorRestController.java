package com.roguljluk.library.controller.rest;

import com.roguljluk.library.model.dto.AuthorCreationDTO;
import com.roguljluk.library.model.dto.AuthorDTO;
import com.roguljluk.library.service.api.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorRestController {

    private final AuthorService authorService;

    public AuthorRestController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping(value = "/")
    public ResponseEntity<AuthorDTO> createAuthor(@RequestBody AuthorCreationDTO authorCreationDTO){
        return ResponseEntity.ok(authorService.createNewAuthor(authorCreationDTO));
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<AuthorDTO>> getAll(){
        return ResponseEntity.ok(authorService.getAllAuthors());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuthorDTO> getAuthor(@NotNull @PathVariable Long id){
        return ResponseEntity.ok(authorService.getAuthor(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuthorDTO> updateAuthor(@NotNull @PathVariable Long id, @Valid @RequestBody AuthorDTO authorDTO){
        return ResponseEntity.ok(authorService.updateAuthor(id, authorDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAuthor(@NotNull @PathVariable Long id){
        authorService.deleteAuthor(id);
        return ResponseEntity.ok(null);
    }
}
