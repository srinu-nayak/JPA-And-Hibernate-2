package com.example.Alien.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.Alien.model.Author;
import com.example.Alien.model.Book;
import com.example.Alien.repository.AuthorJpaRepository;
import com.example.Alien.repository.AuthorRepository;
import com.example.Alien.repository.BookJpaRepository;

@Service
public class AuthorJpaService implements AuthorRepository {
    @Autowired
    AuthorJpaRepository authorJpaRepository;

    @Autowired
    BookJpaRepository bookJpaRepository;

    @Override
    public ArrayList<Author> getAuthors() {
        List<Author> listAuthors = authorJpaRepository.findAll();
        ArrayList<Author> authors = new ArrayList<>(listAuthors);
        return authors;
    }

    @Override
    public Author getAuthorById(int authorId) {
        try {
            Author author = authorJpaRepository.findById(authorId).get();
            return author;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        
    }

    @Override
    public Author addAuthor(Author author) {
        return authorJpaRepository.save(author);      
    }

    @Override
    public Author updateAuthor(int authorId, Author author) {
        try {
            Author author2 = authorJpaRepository.findById(authorId).get();
            
            if(author.getAuthorName() != null) {
                author2.setAuthorName(author.getAuthorName());
            }
            return authorJpaRepository.save(author2);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, ("author not updated"));
        }
    }

    @Override
    public void deleteAuthor(int authorId) {
        
        
        try {
        Author author = authorJpaRepository.findById(authorId).get();
        List<Book> books = author.getBooks();

        for (Book book: books) {
            book.getAuthors().remove(author);
            authorJpaRepository.deleteById(authorId);
        }
        bookJpaRepository.saveAll(books);
        authorJpaRepository.deleteById(authorId);
    }   
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }



}
