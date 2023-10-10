package com.WDA.bookstore.exceptions.rent;

public class RentCantBeDeletedException extends RuntimeException {
    public RentCantBeDeletedException() {
<<<<<<< HEAD
        super("Os aluguéis não podem ser deletados!");
=======
        super("O aluguel não pode ser deletado pois não foi devolvido!");
>>>>>>> ee54ec78baaa1faf65652bfae8fb0938275649e4
    }
}
