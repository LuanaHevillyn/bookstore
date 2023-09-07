package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.BookDTO;
import com.WDA.bookstore.models.Book;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("bookDocs")
public class BookDocs {

    private ModelMapper modelMapper;

    public BookDocs() {
        modelMapper = new ModelMapper();
    }

    public Book mapTo(BookDTO bookDTO) {
        return modelMapper.map(bookDTO, Book.class);
    }

}
