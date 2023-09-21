package com.WDA.bookstore.services;

import com.WDA.bookstore.dtos.outputs.BookOutput;
import com.WDA.bookstore.exceptions.CantDeleteException;
import com.WDA.bookstore.exceptions.EntityAlreadyExistsException;
import com.WDA.bookstore.exceptions.illegalArgumentException;
import com.WDA.bookstore.exceptions.illegalArgumentException.LaunchYearItsNotValid;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.utils.MapperBase;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class BookService {

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

    public List<Book> MostRented() {
        return mapperBase.toList(bookRepository.findMostRented(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public List<Book> ListOfMostRented() {
        return mapperBase.toList(bookRepository.findListOfMostRented(), new TypeToken<List<BookOutput>>() {
        }.getType());
    }

    public void create(Book book) {
        book.getId();
        Publisher publisher = book.getPublisher();
        checkIfCanCreateBook(publisher, book);
    }

    @Transactional
    public void update(Book book) {
        book.getId();
        Publisher publisher = book.getPublisher();
        checkIfCanUpdateBook(publisher, book);
    }

    public void delete(Long id) {
        Book book = bookRepository.findById(id).get();
        Publisher publisher = book.getPublisher();
        if(book.getTotal_leased() > 0) {
            throw new CantDeleteException.BookCantBeDeleted();
        } else {
            bookRepository.deleteById(id);
            publisher.setRelated_books(publisher.getRelated_books() - 1);
            publisherRepository.save(publisher);
        }
    }

    public boolean currentYearIsBiggerThanLaunchYear(Integer launchYear) {
        int currentYear = LocalDate.now().getYear();
        return launchYear > currentYear;
    }

    private void checkIfCanUpdateBook(Publisher publisher, Book book) {
        if(bookRepository.existsByPublisherAndName(publisher, book.getName())) {
            throw new EntityAlreadyExistsException.PublisherAlreadyRelatedException();
        } else if(currentYearIsBiggerThanLaunchYear(book.getLaunch())) {
            throw new illegalArgumentException.LaunchYearItsNotValid();
        } else {
            bookRepository.save(book);
            publisher.setRelated_books(publisher.getRelated_books() + 1);
            publisherRepository.save(publisher);
        }
    }

    private void checkIfCanCreateBook(Publisher publisher, Book book) {
        if(bookRepository.existsByPublisherAndName(publisher, book.getName())) {
            throw new EntityAlreadyExistsException.PublisherAlreadyRelatedException();
        } else if(currentYearIsBiggerThanLaunchYear(book.getLaunch())) {
            throw new LaunchYearItsNotValid();
        } else {
            publisher.setRelated_books(publisher.getRelated_books() + 1);
            publisherRepository.save(publisher);
            bookRepository.save(book);
        }
    }

}
