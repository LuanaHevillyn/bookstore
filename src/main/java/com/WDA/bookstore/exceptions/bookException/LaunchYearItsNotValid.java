package com.WDA.bookstore.exceptions.bookException;

public class LaunchYearItsNotValid extends IllegalArgumentException {

    public LaunchYearItsNotValid() {
        super(String.format("Digite um ano igual ao menor que o ano atual!"));
    }
}
