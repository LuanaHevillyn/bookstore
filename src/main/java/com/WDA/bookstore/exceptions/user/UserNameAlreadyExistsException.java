package com.WDA.bookstore.exceptions.user;

import javax.persistence.EntityExistsException;

public class UserNameAlreadyExistsException extends EntityExistsException {
    public UserNameAlreadyExistsException() {
        super("O nome já foi relacionado a algum usuário!");
    }
}
