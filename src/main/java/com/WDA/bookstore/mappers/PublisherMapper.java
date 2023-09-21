package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.inputs.PublisherInput;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component("publisherDocs")
public class PublisherMapper {

    private ModelMapper modelMapper;

    public PublisherMapper() {
        modelMapper = new ModelMapper();
    }

    public Publisher mapTo(@Valid PublisherInput publisherInput) {
        return modelMapper.map(publisherInput, Publisher.class);
    }
}
