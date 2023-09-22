package com.WDA.bookstore.validations.publisher;

import com.WDA.bookstore.exceptions.publisher.PublisherCantBeDeletedException;
import com.WDA.bookstore.exceptions.publisher.PublisherNameAlreadyExistsException;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PublisherEntityValidatorImpl implements PublisherEntityValidator {

    @Autowired
    private PublisherRepository publisherRepository;


    @Override
    public void validateForCreate(Publisher publisher) {
        validateName(publisher);
    }

    @Override
    public void validateForUpdate(Publisher publisher) {
        validateName(publisher);
    }

    @Override
    public void validateForDelete(Long id) {
        validateRelatedBooks(id);
    }

    private void validateName(Publisher publisher) {
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new PublisherNameAlreadyExistsException();
        }
    }

    private void validateRelatedBooks(Long id) {
        Publisher publisher = publisherRepository.findById(id).get();
        if(publisher.getRelatedBooks() > 0) {
            throw new PublisherCantBeDeletedException();
        }
    }
}
