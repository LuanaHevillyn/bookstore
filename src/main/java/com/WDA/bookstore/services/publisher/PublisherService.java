package com.WDA.bookstore.services.publisher;

import com.WDA.bookstore.dtos.publisher.PublisherGetDTO;
import com.WDA.bookstore.models.Publisher;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component

public interface PublisherService {

    List<Publisher> findAll();
    List<Publisher> findMostUsed();

    PublisherGetDTO findById(Long id);

    void create(Publisher publisher);

    void delete(Long id);

    void update(Publisher publisher);
}
