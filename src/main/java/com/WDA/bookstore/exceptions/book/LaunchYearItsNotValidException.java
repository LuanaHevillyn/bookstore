package com.WDA.bookstore.exceptions.book;

public class LaunchYearItsNotValidException extends IllegalArgumentException {
    public LaunchYearItsNotValidException() {
<<<<<<< HEAD
        super("Digite um ano igual ou menor que o ano atual!");
=======
        super(String.format("Digite um ano igual ou menor que o ano atual!"));
>>>>>>> ee54ec78baaa1faf65652bfae8fb0938275649e4
    }


}
