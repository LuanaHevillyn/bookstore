package com.WDA.bookstore.exceptions.user;

public class UserCantBeDeletedException extends RuntimeException {
    public UserCantBeDeletedException() {
        super("O usuário não pode ser deletado pois possui aluguéis!");
    }
}
