package com.WDA.bookstore.exceptions.book;

public class AmountIsZero extends IllegalArgumentException {

    public AmountIsZero() {
        super(String.format("O livro não pode ser alugado pois tem 0 no estoque!"));
    }
}
