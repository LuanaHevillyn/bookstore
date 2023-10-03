package com.WDA.bookstore.exceptions.publisher;

public class PublisherDoesntExistException extends IllegalArgumentException{

    public PublisherDoesntExistException() {
        super("A editora não existe!");
    }
}
