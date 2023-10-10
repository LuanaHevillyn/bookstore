package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.book.BookCreateDTO;
import com.WDA.bookstore.dtos.book.BookUpdateDTO;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book mapTo(BookCreateDTO bookCreateDTO) {
        Book book = new Book();
        Publisher publisher = new Publisher();
        book.setId(0L);
        book.setName(bookCreateDTO.getName());
        book.setAmount(bookCreateDTO.getAmount());
        book.setAuthor(bookCreateDTO.getAuthor());
        publisher.setId(bookCreateDTO.getPublisherId());
        book.setPublisher(publisher);
        book.setLaunch(bookCreateDTO.getLaunch());
        return book;
    }

    public Book mapTo(BookUpdateDTO bookUpdateDTO) {
        Book book = new Book();
        Publisher publisher = new Publisher();
        book.setId(bookUpdateDTO.getId());
        book.setName(bookUpdateDTO.getName());
        book.setAmount(bookUpdateDTO.getAmount());
        book.setAuthor(bookUpdateDTO.getAuthor());
        publisher.setId(bookUpdateDTO.getPublisherId());
        book.setPublisher(publisher);
        book.setLaunch(bookUpdateDTO.getLaunch());
        return book;
    }
}
