package com.WDA.bookstore.services.book;

import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
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
import java.util.Optional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookEntityValidator bookEntityValidator;

    @Autowired
    private PublisherRepository publisherRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private MapperBase mapperBase;

    @Override
    public List<Book> findAll() {
        return mapperBase.toList(bookRepository.findAll(), new TypeToken<List<BookGetDTO>>() {
        }.getType());
    }

    @Override
    public List<Book> mostRented() {
        return mapperBase.toList(bookRepository.findMostRented(), new TypeToken<List<BookGetDTO>>() {
        }.getType());
    }

    @Override
    public List<Book> listOfMostRented() {
        return mapperBase.toList(bookRepository.findListOfMostRented(), new TypeToken<List<BookGetDTO>>() {
        }.getType());
    }

    @Override
    public List<Book> listOfAvailable() {
        return mapperBase.toList(bookRepository.findListOfAvaliable(), new TypeToken<List<BookGetDTO>>() {
        }.getType());
    }

    public BookGetDTO findById(Long id) {
        return bookRepository.findById(id)
                .map(book -> mapperBase.mapTo(book, BookGetDTO.class))
                .orElseThrow(() -> new BookDoesntExistException());
    }

    @Override
    public void create(Book book) {
        bookEntityValidator.validateForCreate(book);
        bookRepository.save(book);
    }

    @Override
    public void update(Book book) {
        bookEntityValidator.validateForUpdate(book);
        bookRepository.save(book);
    }

    @Override
    public void delete(Long id) {
        bookEntityValidator.validateForDelete(id);
        bookRepository.deleteById(id);
    }
}
