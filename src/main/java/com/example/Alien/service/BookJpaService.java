package com.example.Alien.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Alien.model.Author;
import com.example.Alien.model.Book;
import com.example.Alien.model.Publisher;
import com.example.Alien.repository.AuthorJpaRepository;
import com.example.Alien.repository.BookJpaRepository;
import com.example.Alien.repository.BookRepository;
import com.example.Alien.repository.PublisherJpaRepository;


@Service
public class BookJpaService implements BookRepository{

    @Autowired
    BookJpaRepository bookJpaRepository;

    @Autowired
    PublisherJpaRepository publisherJpaRepository;

    @Autowired
    AuthorJpaRepository authorJpaRepository;

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
        List<Integer> authodIds = new ArrayList<>();
       for (Author author: book.getAuthors()) {
        authodIds.add(author.getAuthorId());
       }

       Publisher publisher = book.getPublisher();
       int publisherId = publisher.getPublisherId();
       try {
        List<Author> completeAuthors = authorJpaRepository.findAllById(authodIds);
       if(authodIds.size() != completeAuthors.size()) {
        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "one or more author ids not found");
       }
       book.setAuthors(completeAuthors);


        Publisher completePublisher = publisherJpaRepository.findById(publisherId).get();
        book.setPublisher(completePublisher);
        bookJpaRepository.save(book);
        return book;
       }
       catch(NoSuchElementException e) {
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

    @Override
    public List<Author> getBookAuthors(int bookId) {
        try {
            Book book = bookJpaRepository.findById(bookId).get();
            return book.getAuthors();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    
}
