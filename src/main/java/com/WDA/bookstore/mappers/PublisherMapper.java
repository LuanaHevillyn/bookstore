package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.publisher.PublisherCreateDTO;
import com.WDA.bookstore.dtos.publisher.PublisherUpdateDTO;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class PublisherMapper {

    public Publisher mapTo(@Valid PublisherCreateDTO publisherCreateDTO) {
        Publisher publisher = new Publisher();
        publisher.setId(0L);
        publisher.setName(publisherCreateDTO.getName());
        publisher.setCity(publisherCreateDTO.getCity());
        return publisher;
    }

    public Publisher mapTo(@Valid PublisherUpdateDTO publisherUpdateDTO) {
        Publisher publisher = new Publisher();
        publisher.setId(publisherUpdateDTO.getId());
        publisher.setName(publisherUpdateDTO.getName());
        publisher.setCity(publisherUpdateDTO.getCity());
        return publisher;
    }
}
