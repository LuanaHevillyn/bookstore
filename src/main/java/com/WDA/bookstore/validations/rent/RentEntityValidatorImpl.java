package com.WDA.bookstore.validations.rent;

import com.WDA.bookstore.exceptions.book.AmountIsZeroException;
import com.WDA.bookstore.exceptions.book.BookDoesntExistException;
import com.WDA.bookstore.exceptions.rent.RentCantBeDeletedException;
import com.WDA.bookstore.exceptions.user.UserDoesntExistException;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import com.WDA.bookstore.repositories.BookRepository;
import com.WDA.bookstore.repositories.RentRepository;
import com.WDA.bookstore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RentEntityValidatorImpl implements RentEntityValidator {

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void validateForCreate(Rent rent) {
        validateUserAndBook(rent);
    }

    @Override
    public void validateForDelete(Long id) {
        validateReturnDate(id);
    }

    private void validateUserAndBook(Rent rent) {
        if (userRepository.existsById(rent.getUser().getId()) && bookRepository.existsById(rent.getBook().getId())){
            Optional<User> userOptional = userRepository.findById(rent.getUser().getId());
            Optional<Book> bookOptional = bookRepository.findById(rent.getBook().getId());
            if (bookOptional.isEmpty()) {
                throw new BookDoesntExistException();
            } else if (userOptional.isEmpty()) {
                throw new UserDoesntExistException();
            } else {
                Book book = bookOptional.get();
                if (book.getAmount() > 0) {
                    throw new AmountIsZeroException();
                }
            }
        }
    }

    private void validateReturnDate(Long id) {
        Rent rent = rentRepository.findById(id).get();
        if(rent.getReturnDate() == null) {
            throw new RentCantBeDeletedException();
        }
    }
}
