package com.WDA.bookstore.exceptions.book;

public class LaunchYearItsNotValidException extends IllegalArgumentException {
    public LaunchYearItsNotValidException() {
        super(String.format("Digite um ano igual ou menor que o ano atual!"));
    }


}
