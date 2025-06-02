package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.domain.Author;
import org.example.domain.Book;
import org.example.dto.BookRequestDTO;
import org.example.service.AuthorService;
import org.example.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BooksController {

    private final BookService bookService;
    private final AuthorService authorService;

    @GetMapping
    public List<Book> getAll() {
        return bookService.findAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getById(@PathVariable int id) {
        Book book = bookService.findBookById(id);
        return book != null
                ? ResponseEntity.ok(book)
                : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Book> create(@RequestBody BookRequestDTO dto) {
        Author author = authorService.findAuthorById(dto.getAuthorId());
        if (author == null) {
            return ResponseEntity.status(404).body(null); // Если не найден автор по полученному JSON
        }

        Book book = Book.builder()
                .name(dto.getName())
                .author(author)
                .build();

        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @PutMapping("/{bookId}/author/{authorId}")
    public ResponseEntity<Book> changeBookAuthor(
            @PathVariable int bookId,
            @PathVariable int authorId) {

        Book book = bookService.findBookById(bookId);
        if (book == null) {
            return ResponseEntity.status(404).body(null);
        }

        Author author = authorService.findAuthorById(authorId);
        if (author == null) {
            return ResponseEntity.status(404).body(null);
        }

        book.setAuthor(author);
        return ResponseEntity.ok(bookService.saveBook(book));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}
