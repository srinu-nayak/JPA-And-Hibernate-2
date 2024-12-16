package com.example.Alien.repository;

import com.example.Alien.model.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface PublisherRepository {
    ArrayList<Publisher> getPublishers();

    Publisher getPublisherById(int publisherId);

    Publisher addPublisher(Publisher publisher);

    Publisher updatePublisher(int publisherId, Publisher publisher);

    void deletePublisher(int publisherId);

}
