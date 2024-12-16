package com.example.Alien.repository;

import java.util.ArrayList;
import com.example.Alien.model.Publisher;

import com.example.Alien.model.Book;

public interface BookRepository {
    ArrayList<Book> getBooks();

    Book getBookById(int bookId);

    Book addBook(Book book);

    Book updateBook(int bookId, Book book);

    void deleteBook(int bookId);

    Publisher getBookPublisher(int bookId);

}
