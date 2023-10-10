package com.WDA.bookstore.exceptions.rent;

public class RentDoesntExistException extends IllegalArgumentException{

    public RentDoesntExistException() {
        super("O aluguel não existe!");
    }
}
