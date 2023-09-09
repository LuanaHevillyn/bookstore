package com.WDA.bookstore.exceptions.publisherException;

import javax.persistence.EntityExistsException;

public class PublisherNameAlredyExistsException extends EntityExistsException {

    public PublisherNameAlredyExistsException(String name) {
        super(String.format ( "O nome já foi relacionado a alguma editora!" ));
    }
}
