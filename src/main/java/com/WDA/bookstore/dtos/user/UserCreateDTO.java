package com.WDA.bookstore.dtos.user;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class UserCreateDTO {

    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Cidade não pode estar vazia!")
    private String city;

    @NotEmpty(message = "E-mail não pode estar vazia!")
    @Email
    private String email;

    @NotEmpty(message = "Endereço não pode estar vazio!")
    private String address;

}
