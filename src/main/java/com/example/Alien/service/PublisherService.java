package com.example.Alien.service;

import com.example.Alien.model.Publisher;
import com.example.Alien.repository.PublisherJpaRepository;
import com.example.Alien.repository.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherService implements PublisherRepository {

    @Autowired
    PublisherJpaRepository publisherJpaRepository;

    @Override
    public ArrayList<Publisher> getPublishers() {
        List<Publisher> listPublishers = publisherJpaRepository.findAll();
        return new ArrayList<>(listPublishers);
    }

    @Override
    public Publisher getPublisherById(int publisherId) {
        try {
            Publisher publisher = publisherJpaRepository.findById(publisherId).get();
            return publisher;
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Publisher addPublisher(Publisher publisher) {
        publisherJpaRepository.save(publisher);
        return publisher;
    }

    @Override
    public Publisher updatePublisher(int publisherId, Publisher publisher) {
        try {
            Publisher publisher2 = publisherJpaRepository.findById(publisherId).get();
            if(publisher.getPublisherName() != null) {
                publisher2.setPublisherName(publisher.getPublisherName());
            }
            return publisherJpaRepository.save(publisher2);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletePublisher(int publisherId) {
        try {
            publisherJpaRepository.deleteById(publisherId);
        }
        catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}
