package com.example.Alien.repository;


import com.example.Alien.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherJpaRepository extends JpaRepository<Publisher, Integer> {

    
}
