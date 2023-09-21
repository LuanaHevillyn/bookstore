package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.inputs.BookInput;
import com.WDA.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("bookDocs")
public class BookMapper {

    private ModelMapper modelMapper;

    public BookMapper() {
        modelMapper = new ModelMapper();
    }

    public Book mapTo(BookInput bookInput) {
        return modelMapper.map(bookInput, Book.class);
    }

}
