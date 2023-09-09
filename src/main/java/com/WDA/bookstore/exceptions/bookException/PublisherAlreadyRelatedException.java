package com.WDA.bookstore.exceptions.bookException;

import javax.persistence.EntityExistsException;

public class PublisherAlreadyRelatedException extends EntityExistsException {


    public PublisherAlreadyRelatedException() {
        super(String.format("A editora já foi relacionada a este livro!"));
    }
}
