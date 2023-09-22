package com.WDA.bookstore.exceptions.user;

import javax.persistence.EntityExistsException;

public class UserEmailAlreadyExistsException extends EntityExistsException {

    public UserEmailAlreadyExistsException() {
        super("O e-mail já foi relacionado a algum usuário!");
    }
}
