package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.publisher.PublisherCreateDTO;
import com.WDA.bookstore.dtos.publisher.PublisherUpdateDTO;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component("publisherDocs")
public class PublisherMapper {

    private ModelMapper modelMapper;

    public PublisherMapper() {
        modelMapper = new ModelMapper();
    }

    public Publisher mapTo(@Valid PublisherCreateDTO publisherCreateDTO) {
        return modelMapper.map(publisherCreateDTO, Publisher.class);
    }

    public Publisher mapTo(@Valid PublisherUpdateDTO publisherUpdateDTO) {
        return modelMapper.map(publisherUpdateDTO, Publisher.class);
    }

}
