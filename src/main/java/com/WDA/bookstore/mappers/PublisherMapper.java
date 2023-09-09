package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("publisherDocs")
public class PublisherMapper {

    private ModelMapper modelMapper;

    public PublisherMapper() {
        modelMapper = new ModelMapper();
    }

    public Publisher mapTo(PublisherDTO publisherDTO) {
        return modelMapper.map(publisherDTO, Publisher.class);
    }
}
