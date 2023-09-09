package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("bookDocs")
public class BookMapper {

    private ModelMapper modelMapper;

    public BookMapper() {
        modelMapper = new ModelMapper();
    }

    public Book mapTo(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

}
