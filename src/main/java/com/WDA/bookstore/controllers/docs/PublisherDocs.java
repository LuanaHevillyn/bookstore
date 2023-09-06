package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("publisherDocs")
public class PublisherDocs {

    private ModelMapper modelMapper;

    final Converter<PublisherDTO, Publisher> publisherConverter = new Converter<PublisherDTO, Publisher>() {

        @Override
        public Publisher convert(MappingContext<PublisherDTO, Publisher> context) {
            PublisherDTO publisherDTO = context.getSource();
            Publisher publisher = new Publisher();
            publisher.setName (publisherDTO.getName ());
            publisher.setCity (publisherDTO.getCity ());

            return publisher;
        }
    };

    public PublisherDocs() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(publisherConverter);
    }

    public Publisher mapTo(PublisherDTO publisherDTO) {
        return this.modelMapper.map(publisherDTO, Publisher.class);
    }
}
