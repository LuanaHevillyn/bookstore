package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.BookOutput;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import com.WDA.bookstore.validations.book.BookEntityValidator;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookService {

    @Autowired
    private BookEntityValidator bookEntityValidator;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MapperBase mapperBase;

    public List<BookOutput> findAll() {
        return mapperBase.toList(bookRepository.findAll(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public List<Book> mostRented() {
        return mapperBase.toList(bookRepository.findMostRented(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public List<Book> listOfMostRented() {
        return mapperBase.toList(bookRepository.findListOfMostRented(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public List<Book> listOfAvailable() {
        return mapperBase.toList(bookRepository.findListOfAvaliable(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public void create(Book book) {
        bookEntityValidator.validateForCreate(book);
        bookRepository.save(book);
        book.getPublisher().setRelatedBooks(book.getPublisher().getRelatedBooks() + 1);
        publisherRepository.save(book.getPublisher());
    }

    public void update(Book book) {
        bookEntityValidator.validateForUpdate(book);
        bookRepository.save(book);
        book.getPublisher().setRelatedBooks(book.getPublisher().getRelatedBooks() + 1);
        publisherRepository.save(book.getPublisher());
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id).get();
        bookEntityValidator.validateForDelete(id);
        bookRepository.deleteById(id);
        book.getPublisher().setRelatedBooks(book.getPublisher().getRelatedBooks() - 1);
        publisherRepository.save(book.getPublisher());
    }
}
