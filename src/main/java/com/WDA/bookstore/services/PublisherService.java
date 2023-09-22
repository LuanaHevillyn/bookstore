package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.PublisherOutput;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import com.WDA.bookstore.validations.publisher.PublisherEntityValidator;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService {
    @Autowired
    private PublisherEntityValidator publisherEntityValidator;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<PublisherOutput> findAll() {
        return mapperBase.toList(publisherRepository.findAll(), new TypeToken<List<PublisherOutput>>() {
        }.getType());
    }

    public List<Publisher> findMostUsed() {
        return mapperBase.toList(publisherRepository.findMostUsed(), new TypeToken<List<PublisherOutput>>() {
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
