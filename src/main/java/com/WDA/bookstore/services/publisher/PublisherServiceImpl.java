package com.WDA.bookstore.services.publisher;

import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.dtos.publisher.PublisherGetDTO;
import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
import com.WDA.bookstore.exceptions.publisher.PublisherDoesntExistException;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import com.WDA.bookstore.validations.publisher.PublisherEntityValidator;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherServiceImpl implements PublisherService{
    @Autowired
    private PublisherEntityValidator publisherEntityValidator;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<Publisher> findAll() {
        return mapperBase.toList(publisherRepository.findAll(), new TypeToken<List<PublisherGetDTO>>() {
        }.getType());
    }

    public PublisherGetDTO findById(Long id) {
        return publisherRepository.findById(id)
                .map(publisher -> mapperBase.mapTo(publisher, PublisherGetDTO.class))
                .orElseThrow(() -> new PublisherDoesntExistException());
    }

    public List<Publisher> findMostUsed() {
        return mapperBase.toList(publisherRepository.findMostUsed(), new TypeToken<List<PublisherGetDTO>>() {
        }.getType());
    }

    public void create(Publisher publisher) {
        publisherEntityValidator.validateForCreate(publisher);
        publisherRepository.save(publisher);
    }

    public void delete(Long id) {
        publisherEntityValidator.validateForDelete(id);
        publisherRepository.deleteById(id);
    }

    public void update(Publisher publisher) {
        publisherEntityValidator.validateForUpdate(publisher);
        publisherRepository.save(publisher);
    }
}
