package com.WDA.bookstore.validations.user;

import com.WDA.bookstore.models.User;

public interface UserEntityValidator {

    void validateForCreate(User user);

    void validateForUpdate(User user);

    void validateForDelete(Long id);
}
