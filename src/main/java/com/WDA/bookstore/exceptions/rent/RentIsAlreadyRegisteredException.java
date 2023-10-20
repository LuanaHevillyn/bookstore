package com.WDA.bookstore.exceptions.rent;

import javax.persistence.EntityExistsException;

public class RentIsAlreadyRegisteredException extends EntityExistsException {

    public RentIsAlreadyRegisteredException() {
        super("O aluguel já foi registrado com este livro e este usuário!");
    }

}
