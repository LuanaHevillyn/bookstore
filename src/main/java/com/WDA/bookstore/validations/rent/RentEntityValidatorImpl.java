package com.WDA.bookstore.validations.rent;

import com.WDA.bookstore.exceptions.book.AmountIsZero;
import com.WDA.bookstore.exceptions.rent.RentCantBeDeletedException;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.repositories.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RentEntityValidatorImpl implements RentEntityValidator {

    @Autowired
    private RentRepository rentRepository;

    @Override
    public void validateForCreate(Rent rent) {
        validateUserAndBook(rent);
    }

    @Override
    public void validateForDelete(Long id) {
        validateReturnDate(id);
    }

    private void validateUserAndBook(Rent rent) {
        if(rent.getBook() == null && rent.getUser() == null && rent.getBook().getAmount() < 0) {
            throw new AmountIsZero();
        }
    }

    private void validateReturnDate(Long id) {
        Rent rent = rentRepository.findById(id).get();
        if(rent.getReturnDate() == null) {
            throw new RentCantBeDeletedException();
        }
    }
}
