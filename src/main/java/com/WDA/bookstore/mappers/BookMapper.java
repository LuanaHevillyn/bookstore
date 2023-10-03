package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.book.BookCreateDTO;
import com.WDA.bookstore.dtos.book.BookUpdateDTO;
import com.WDA.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("bookDocs")
public class BookMapper {

    private ModelMapper modelMapper;

    public BookMapper() {
        modelMapper = new ModelMapper();
    }

    public Book mapTo(BookCreateDTO bookCreateDTO) {
        return modelMapper.map(bookCreateDTO, Book.class);
    }

    public Book mapTo(BookUpdateDTO bookUpdateDTO) {
        return modelMapper.map(bookUpdateDTO, Book.class);
    }
}
