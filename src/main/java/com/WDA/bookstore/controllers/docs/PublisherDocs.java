package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("publisherDocs")
public class PublisherDocs {

    private ModelMapper modelMapper;

    public PublisherDocs() {
        modelMapper = new ModelMapper();
    }

    public Publisher mapTo(PublisherDTO publisherDTO) {
        return modelMapper.map(publisherDTO, Publisher.class);
    }
}
