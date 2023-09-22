package com.WDA.bookstore.exceptions.publisher;

import javax.persistence.EntityExistsException;

public class PublisherNameAlreadyExistsException extends EntityExistsException {

    public PublisherNameAlreadyExistsException() {
        super("Uma editora já existe com esse nome!");
    }
}
