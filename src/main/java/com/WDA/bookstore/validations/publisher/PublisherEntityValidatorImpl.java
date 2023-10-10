package com.WDA.bookstore.validations.publisher;

import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
import com.WDA.bookstore.exceptions.publisher.PublisherCantBeDeletedException;
import com.WDA.bookstore.exceptions.publisher.PublisherDoesntExistException;
import com.WDA.bookstore.exceptions.publisher.PublisherNameAlreadyExistsException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.PublisherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PublisherEntityValidatorImpl implements PublisherEntityValidator {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void validateForCreate(Publisher publisher) {
        validateNameForCreate(publisher);
    }

    @Override
    public void validateForUpdate(Publisher publisher) {
        validatePublisherId(publisher);
        validateNameForUpdate(publisher);
    }

    @Override
    public void validateForDelete(Long id) {
        validateRelatedBooks(id);
    }

    private void validateNameForCreate(Publisher publisher) {
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new PublisherNameAlreadyExistsException();
        }
    }
    private void validateNameForUpdate(Publisher publisher) {
        if(publisherRepository.existsByNameAndIdNot(publisher.getName(), publisher.getId())) {
            throw new PublisherNameAlreadyExistsException();
        }
    }

    private void validatePublisherId(Publisher publisher) {
        boolean publisherOptional = publisherRepository.existsById(publisher.getId());
        if (!publisherOptional) {
            throw new PublisherDoesntExistException();
        }
    }

    private void validateRelatedBooks(Long id) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(id);
        if (publisherOptional.isPresent()) {
            Publisher publisher = publisherOptional.get();
            if (bookRepository.existsByPublisher(publisher)) {
                throw new PublisherCantBeDeletedException();
            }
        }else{
            throw new PublisherDoesntExistException();
        }
    }
}
