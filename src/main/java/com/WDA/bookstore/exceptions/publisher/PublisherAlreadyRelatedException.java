package com.WDA.bookstore.exceptions.publisher;

import javax.persistence.EntityExistsException;

public class PublisherAlreadyRelatedException extends EntityExistsException {

    public PublisherAlreadyRelatedException() {
        super("A editora já foi relacionada a este livro!");
    }
}
