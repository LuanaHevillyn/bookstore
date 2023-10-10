package com.WDA.bookstore.validations.book;

import com.WDA.bookstore.exceptions.book.AmountCantBeLessThanTheOldValueException;
import com.WDA.bookstore.exceptions.book.BookCantBeDeletedException;
import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
import com.WDA.bookstore.exceptions.book.LaunchYearItsNotValidException;
import com.WDA.bookstore.exceptions.publisher.PublisherAlreadyRelatedException;
import com.WDA.bookstore.exceptions.publisher.PublisherDoesntExistException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.PublisherRepository;
import com.WDA.bookstore.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;


@Component
public class BookEntityValidatorImpl implements BookEntityValidator {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private PublisherRepository publisherRepository;

    @Override
    public void validateForCreate(Book book) {
        validatePublisherAndName(book);
        validateLaunchYear(book);
    }

    @Override
    public void validateForUpdate(Book book) {
        validateBookId(book);
        validatePublisherAndName(book);
        validateAmount(book);
    }

    @Override
    public void validateForDelete(Long id) {
        validateTotalLeased(id);
    }

    private void validatePublisherAndName(Book book) {
        Optional<Publisher> publisherOptional = publisherRepository.findById(book.getPublisher().getId());
        if (publisherOptional.isPresent()) {
            Publisher publisher = publisherOptional.get();
            if (bookRepository.existsByPublisherAndNameAndIdNot(publisher, book.getName(), book.getId())) {
                throw new PublisherAlreadyRelatedException();
            }
        }else {
            throw new PublisherDoesntExistException();
        }
    }

    private void validateLaunchYear(Book book) {
        if(currentYearIsBiggerThanLaunchYear(book.getLaunch())) {
            throw new LaunchYearItsNotValidException();
        }
    }

    private void validateBookId(Book book) {
        boolean bookOptional = bookRepository.existsById(book.getId());
        if (!bookOptional) {
            throw new BookDoesntExistException();
        }
    }

    private void validateAmount(Book book) {
        Optional<Book> bookOptional = bookRepository.findById(book.getId());
        if (bookOptional.isPresent()) {
            int newAmount = book.getAmount();
            int existingBook = bookOptional.get().getAmount();
            if (existingBook > newAmount){
                throw new AmountCantBeLessThanTheOldValueException();
            }
        }
    }


    public boolean currentYearIsBiggerThanLaunchYear(Integer launchYear) {
        int currentYear = LocalDate.now().getYear();
        return launchYear > currentYear;
    }

    private void validateTotalLeased(Long id) {
        Optional<Book> bookOptional = bookRepository.findById(id);
        if (bookOptional.isPresent()){
            Book book = bookOptional.get();
            if (rentRepository.existsByBook(book)) {
                throw new BookCantBeDeletedException();
            }
        }else {
            throw new BookDoesntExistException();
        }
    }
}
