package com.example.Alien.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Alien.model.Author;

public interface AuthorJpaRepository extends JpaRepository<Author, Integer>{


}
