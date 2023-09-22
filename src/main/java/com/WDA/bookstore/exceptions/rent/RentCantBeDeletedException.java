package com.WDA.bookstore.exceptions.rent;

public class RentCantBeDeletedException extends RuntimeException {
    public RentCantBeDeletedException() {
        super("O aluguel não pode ser deletado pois não foi devolvido!");
    }
}
