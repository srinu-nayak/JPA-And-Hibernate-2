package com.example.Alien.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alien.model.Author;
import com.example.Alien.model.Book;
import com.example.Alien.model.Publisher;
import com.example.Alien.service.BookJpaService;

@RestController
public class BookController {

    @Autowired
    private BookJpaService bookJpaService;

    @GetMapping("/books")
    public ArrayList<Book> getBooks() {
        return bookJpaService.getBooks();
    }

    @GetMapping("/books/{bookId}")
    public Book getBookById(@PathVariable(name="bookId") int bookId) {
        return bookJpaService.getBookById(bookId);
    }

    @PostMapping("/publisher/books")
    public Book addBook(@RequestBody Book book) {
        return bookJpaService.addBook(book);
    }

    @PutMapping("/books/{bookId}")
    public Book updateBook(@PathVariable (name = "bookId") int bookId, @RequestBody Book book) {
        return bookJpaService.updateBook(bookId, book);
    }

    @DeleteMapping("books/{bookId}")
    public void deleteBook(@PathVariable("bookId") int bookId) {
         bookJpaService.deleteBook(bookId);
    }

    @GetMapping("/books/{bookId}/publisher")
    public Publisher getBookPublisher(@PathVariable(name="bookId") int bookId) {
        return bookJpaService.getBookPublisher(bookId);
    }

    @GetMapping("/books/{bookId}/authors") 
    public List<Author> getBookAuthors(@PathVariable int bookId) {
        return bookJpaService.getBookAuthors(bookId);
    }



}
