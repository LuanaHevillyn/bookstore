package com.WDA.bookstore.exceptions.userException;

import javax.persistence.EntityExistsException;

public class UserNameAlredyExistsException extends EntityExistsException {

    public UserNameAlredyExistsException(String name) {
        super(String.format ( "O nome já foi relacionado a algum usuário!" ));
    }

}
