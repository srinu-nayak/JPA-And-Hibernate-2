package com.example.Alien.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Alien.model.Book;

@Repository
public interface BookJpaRepository extends JpaRepository<Book, Integer> {

}
