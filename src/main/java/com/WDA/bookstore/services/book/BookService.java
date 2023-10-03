package com.WDA.bookstore.services.book;

import com.WDA.bookstore.dtos.book.BookCreateDTO;
import com.WDA.bookstore.models.Book;
import org.springframework.stereotype.Service;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    List<Book> mostRented();

    List<Book> listOfMostRented();

    List<Book> listOfAvailable();

    void create(Book book);

    void update(Book book);

    void delete(Long id);
}
