package com.WDA.bookstore.exceptions.book;

public class BookCantBeDeletedException extends RuntimeException {
    public BookCantBeDeletedException() {
        super("O livro não pode ser deletado pois possui aluguéis!");
    }

}
