package com.WDA.bookstore.services;

import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService {

    final PublisherRepository publisherRepository;

    public List<Publisher> index() {
        return publisherRepository.findAll();
    }

    public PublisherService(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }

    public Publisher save(Publisher publisher){
        return publisherRepository.save( publisher );
    }

    public Publisher show(Long id) {
        return publisherRepository.getReferenceById ( id );
    }

    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }

    public Publisher update(Long id, Publisher newPublisher) throws Exception {
        Publisher publisher = publisherRepository.getReferenceById ( id );
        if (publisher == null) {
            throw new Exception();
        }
        if (publisher.getId() != id) {
            throw new IllegalArgumentException();
        }

        newPublisher.setId(id);
        Publisher publisherDB = publisherRepository.save(newPublisher);
        return publisherDB;
    }


}
