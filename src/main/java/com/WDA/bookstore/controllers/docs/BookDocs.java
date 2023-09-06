package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.dtos.PublisherDTO;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("bookDocs")
public class BookDocs {


    private ModelMapper modelMapper;

    final Converter<BookDTO, Book> bookConverter = new Converter<BookDTO, Book>() {

        @Override
        public Book convert(MappingContext<BookDTO, Book> context) {
            BookDTO bookDTO = context.getSource();
            Book book = new Book();
            book.setName (bookDTO.getName ());
            book.setAuthor (bookDTO.getAuthor ());
            book.setAmount (bookDTO.getAmount ());
            book.setPublisher (bookDTO.getPublisher ());
            book.setLaunch (bookDTO.getLaunch ());
            book.setTotal_leased (bookDTO.getTotal_leased ());

            return book;
        }
    };

    public BookDocs() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(bookConverter);
    }

    public Book mapTo(BookDTO bookDTO) {
        return this.modelMapper.map(bookDTO, Book.class);
    }

}
