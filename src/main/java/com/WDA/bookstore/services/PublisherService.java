package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.exceptions.publisherException.PublisherNameAlredyExistsException;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PublisherService {

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<PublisherDTO> findAll() {
        return mapperBase.toList(publisherRepository.findAll(), new TypeToken<List<PublisherDTO>>() {
        }.getType());
    }

    public Publisher create(Publisher publisher) {
        Optional<Publisher> publisherName = publisherRepository.findByName(publisher.getName());

        if(publisherName.isPresent()) {
            throw new PublisherNameAlredyExistsException(publisher.getName());
        } else {
            return publisherRepository.save(publisher);
        }
    }

    public void delete(Long id) {
        publisherRepository.deleteById(id);
    }

    public Publisher update(Long id, Publisher publisher) {
        publisher.setId(id);
        Optional<Publisher> publisherName = publisherRepository.findByName(publisher.getName());

        if(publisherName.isPresent()) {
            throw new PublisherNameAlredyExistsException(publisher.getName());
        }
        return publisherRepository.save(publisher);

    }

}
