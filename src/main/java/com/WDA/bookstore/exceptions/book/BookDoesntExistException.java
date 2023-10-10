package com.WDA.bookstore.exceptions.book;

public class BookDoesntExistException extends IllegalArgumentException{

    public BookDoesntExistException() {
        super("O livro não existe!");
    }
}
