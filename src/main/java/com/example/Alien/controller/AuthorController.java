package com.example.Alien.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Alien.model.Author;
import com.example.Alien.service.AuthorJpaService;

@RestController
public class AuthorController {
    @Autowired
    AuthorJpaService authorJpaService;

    @GetMapping("/authors")
    public ArrayList<Author> getAuthors() {
        return authorJpaService.getAuthors();
    }

    @GetMapping("/authors/{authorId}")
    public Author getAuthorById(@PathVariable int authorId) {
        return authorJpaService.getAuthorById(authorId);
    }

    @PostMapping("/authors")
    public Author addAuthor(@RequestBody Author author) {
        return authorJpaService.addAuthor(author);
    }

    @PutMapping("/authors/{authorId}")
    public Author updateAuthor(@PathVariable int authorId, @RequestBody Author author){
        return authorJpaService.updateAuthor(authorId, author);
    }

    @DeleteMapping("/authors/{authorId}")
    public void deleteAuthor(@PathVariable int authorId) {
         authorJpaService.deleteAuthor(authorId);
    }

}
