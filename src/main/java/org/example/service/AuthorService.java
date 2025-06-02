package org.example.service;

import org.example.domain.Author;

import java.util.List;

public interface AuthorService {
    void deleteAuthor(int id);

    Author findAuthorById(int id);

    List<Author> findAllAuthors();

    Author saveAuthor(Author author);
}
