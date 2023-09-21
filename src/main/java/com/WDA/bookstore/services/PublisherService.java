package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.PublisherOutput;
import com.WDA.bookstore.exceptions.CantDeleteException;
import com.WDA.bookstore.exceptions.EntityAlreadyExistsException;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class PublisherService {

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
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new EntityAlreadyExistsException.PublisherNameAlredyExistsException();
        }
        publisherRepository.save(publisher);

    }

    public void delete(Long id) {
        Publisher publisher = publisherRepository.findById(id).get();
        if(publisher.getRelated_books() > 0) {
            throw new CantDeleteException.PublisherCantBeDeleted();
        }
        publisherRepository.deleteById(id);
    }

    public void update(Publisher publisher) {
        publisher.getId();
        if(publisherRepository.existsByName(publisher.getName())) {
            throw new EntityAlreadyExistsException.PublisherNameAlredyExistsException();
        } else {
            publisherRepository.save(publisher);
        }
    }
}
