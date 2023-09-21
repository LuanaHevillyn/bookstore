package com.WDA.bookstore.exceptions;

public class illegalArgumentException extends IllegalArgumentException {

    public illegalArgumentException(String message) {
        super(message);
    }

    public static class LaunchYearItsNotValid extends illegalArgumentException {
        public LaunchYearItsNotValid() {
            super(String.format("Digite um ano igual ou menor que o ano atual!"));
        }
    }

    public static class AmountIsZero extends illegalArgumentException {

        public AmountIsZero() {
            super(String.format("O livro não pode ser alugado pois tem 0 no estoque!"));
        }
    }


}
