package org.example.service;

import org.example.domain.Book;

import java.util.List;

public interface BookService {
    void deleteBook(int id);

    Book findBookById(int id);

    List<Book> findAllBooks();

    Book saveBook(Book book);
}
