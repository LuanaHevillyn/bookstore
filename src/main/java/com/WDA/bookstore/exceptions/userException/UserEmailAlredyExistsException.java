package com.WDA.bookstore.exceptions.userException;

import javax.persistence.EntityExistsException;

public class UserEmailAlredyExistsException extends EntityExistsException {

    public UserEmailAlredyExistsException(String name) {
        super(String.format ( "O e-mail já foi relacionado a algum usuário!" ));
    }

}
