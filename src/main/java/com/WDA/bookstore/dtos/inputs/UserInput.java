package com.WDA.bookstore.dtos.inputs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {

    private Long id;

    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Cidade não pode estar vazio!")
    private String city;

    @NotEmpty(message = "E-mail não pode estar vazio!")
    @Email
    private String email;

    @NotEmpty(message = "Endereço não pode estar vazio!")
    private String address;

    private int totalRents;
}
