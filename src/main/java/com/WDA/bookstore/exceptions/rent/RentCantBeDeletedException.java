package com.WDA.bookstore.exceptions.rent;

public class RentCantBeDeletedException extends RuntimeException {
    public RentCantBeDeletedException() {
        super("Os aluguéis não podem ser deletados!");
    }
}
