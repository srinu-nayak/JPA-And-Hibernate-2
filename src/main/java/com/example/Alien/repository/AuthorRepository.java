package com.example.Alien.repository;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.example.Alien.model.Author;

@Repository
public interface AuthorRepository {
    ArrayList<Author> getAuthors();

    Author getAuthorById(int authorId);

    Author addAuthor(Author author);

    Author updateAuthor(int authorId, Author author);

    void deleteAuthor(int authorId);
}
