package com.WDA.bookstore.exceptions.book;

public class AmountIsZeroException extends IllegalArgumentException {

    public AmountIsZeroException() {
        super("O livro não pode ser alugado pois tem 0 no estoque!");
    }
}
