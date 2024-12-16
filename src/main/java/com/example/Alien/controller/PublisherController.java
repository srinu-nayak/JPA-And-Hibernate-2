package com.example.Alien.controller;

import com.example.Alien.model.Publisher;
import com.example.Alien.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PublisherController {
    @Autowired
    PublisherService publisherService;

    @GetMapping("/publishers")
    public ArrayList<Publisher> getPublishers() {
        return publisherService.getPublishers();
    }

    @GetMapping("/publishers/{publisherId}")
    public Publisher getPublisherById(@PathVariable int publisherId) {
        return publisherService.getPublisherById(publisherId);
    }

    @PostMapping("/publishers") 
    public Publisher addPublisher(@RequestBody Publisher publisher) {
        return publisherService.addPublisher(publisher);
    }

    @PutMapping("/publishers/{publisherId}")
    public Publisher updatePublisher(@PathVariable int publisherId, @RequestBody Publisher publisher) {
        return publisherService.updatePublisher(publisherId, publisher);
    }

    @DeleteMapping("/publishers/{publisherId}")
    public void deletePublisher(@PathVariable int publisherId) {
        publisherService.deletePublisher(publisherId);

    }

}
