package com.WDA.bookstore.exceptions.user;

public class UserDoesntExistException extends IllegalArgumentException{

    public UserDoesntExistException() {
        super("O usuário não existe!");
    }
}
