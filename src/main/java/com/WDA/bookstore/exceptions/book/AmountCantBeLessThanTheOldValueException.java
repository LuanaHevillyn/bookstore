package com.WDA.bookstore.exceptions.book;

public class AmountCantBeLessThanTheOldValueException extends IllegalArgumentException{

    public AmountCantBeLessThanTheOldValueException() {
        super("A quantidade atual não pode ser menor que o antigo valor!");
    }

}
