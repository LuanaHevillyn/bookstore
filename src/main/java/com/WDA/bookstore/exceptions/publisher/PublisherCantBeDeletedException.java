package com.WDA.bookstore.exceptions.publisher;

public class PublisherCantBeDeletedException extends RuntimeException {

    public PublisherCantBeDeletedException() {
        super("A editora não pode ser deletada pois possui livros relacionados a ela!");
    }
}
