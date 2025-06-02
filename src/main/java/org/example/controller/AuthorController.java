package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.dto.ChangeAuthorNameDTO;
import org.example.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
@RequiredArgsConstructor
public class AuthorController {

    private final AuthorService authorService;

    @GetMapping
    public List<Author> getAll() {
        return authorService.findAllAuthors();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Author> getById(@PathVariable int id) {
        Author author = authorService.findAuthorById(id);
        return author != null
                ? ResponseEntity.ok(author)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public Author create(@RequestBody Author author) {
        return authorService.saveAuthor(author);
    }

    @PutMapping("/{authorId}")
    public ResponseEntity<Author> changeAuthorName(
            @PathVariable int authorId,
            @RequestBody ChangeAuthorNameDTO dto) {

        Author author = authorService.findAuthorById(authorId);
        if (author == null) {
            return ResponseEntity.status(404).body(null);
        }

        author.setFio(dto.getFio());
        return ResponseEntity.ok(authorService.saveAuthor(author));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        authorService.deleteAuthor(id);
        return ResponseEntity.noContent().build();
    }
}
