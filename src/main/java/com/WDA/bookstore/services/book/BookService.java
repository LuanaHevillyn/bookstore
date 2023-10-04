package com.WDA.bookstore.services.book;

import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    List<Book> mostRented();

    List<Book> listOfMostRented();

    List<Book> listOfAvailable();

    BookGetDTO findById(Long id);

    void create(Book book);

    void update(Book book);

    void delete(Long id);

}
