package com.example.Alien.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Alien.model.Book;
import com.example.Alien.model.Publisher;
import com.example.Alien.repository.BookJpaRepository;
import com.example.Alien.repository.BookRepository;
import com.example.Alien.repository.PublisherJpaRepository;


@Service
public class BookJpaService implements BookRepository{

    @Autowired
    BookJpaRepository bookJpaRepository;

    @Autowired
    PublisherJpaRepository publisherJpaRepository;

    @Override
    public ArrayList<Book> getBooks() {
       List<Book> bookList = bookJpaRepository.findAll();
       ArrayList<Book> books = new ArrayList<>(bookList);
       return books;       
    }

    @Override
    public Book getBookById(int bookId) {
        try {
            Book book = bookJpaRepository.findById(bookId).get();
            return book;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Book addBook(Book book) {
       Publisher publisher = book.getPublisher();
       int publisherId = publisher.getPublisherId();
       try {
        Publisher completePublisher = publisherJpaRepository.findById(publisherId).get();
        book.setPublisher(completePublisher);
        bookJpaRepository.save(book);
        return book;
       }
       catch(Exception e) {
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "potentially wrong publisherId");
       }
    }

    @Override
    public Book updateBook(int bookId, Book book) {

        try {
            Book book2 = bookJpaRepository.findById(bookId).get();

            if(book.getName() != null) {
                book2.setName(book.getName());
            }
            if (book.getImageUrl() != null) {
                book2.setImageUrl(book.getImageUrl());
            }
            
            bookJpaRepository.save(book2);
            return book2;
            
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } 
        

    }

    @Override
    public void deleteBook(int bookId) {
        try {
            bookJpaRepository.deleteById(bookId);
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
         
    }

    @Override
    public Publisher getBookPublisher(int bookId) {
        try {
            Book book = bookJpaRepository.findById(bookId).get();
            return book.getPublisher();
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
