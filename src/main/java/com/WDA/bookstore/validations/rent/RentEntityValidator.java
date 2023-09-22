package com.WDA.bookstore.validations.rent;

import com.WDA.bookstore.models.Rent;

public interface RentEntityValidator {

    void validateForCreate(Rent rent);

    void validateForDelete(Long id);
}
