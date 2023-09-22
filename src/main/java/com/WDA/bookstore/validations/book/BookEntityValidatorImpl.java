package com.WDA.bookstore.validations.book;

import com.WDA.bookstore.exceptions.book.BookCantBeDeletedException;
import com.WDA.bookstore.exceptions.book.LaunchYearItsNotValidException;
import com.WDA.bookstore.exceptions.publisher.PublisherAlreadyRelatedException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class BookEntityValidatorImpl implements BookEntityValidator {

    @Autowired
    private BookRepository bookRepository;


    @Override
    public void validateForCreate(Book book) {
        validatePublisherAndName(book);
        validateLaunchYear(book);
    }

    @Override
    public void validateForUpdate(Book book) {
        validatePublisherAndName(book);
        validateLaunchYear(book);
    }

    @Override
    public void validateForDelete(Long id) {
        validateAmount(id);
    }

    private void validatePublisherAndName(Book book) {
        if(bookRepository.existsByPublisherAndName(book.getPublisher(), book.getName())) {
            throw new PublisherAlreadyRelatedException();
        }
    }

    private void validateLaunchYear(Book book) {
        if(currentYearIsBiggerThanLaunchYear(book.getLaunch())) {
            throw new LaunchYearItsNotValidException();
        }
    }

    public boolean currentYearIsBiggerThanLaunchYear(Integer launchYear) {
        int currentYear = LocalDate.now().getYear();
        return launchYear > currentYear;
    }

    private void validateAmount(Long id) {
        Book book = bookRepository.findById(id).get();
        if(book.getTotalLeased() > 0) {
            throw new BookCantBeDeletedException();
        }
    }
}
