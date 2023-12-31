package com.WDA.bookstore.dtos.publisher;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class PublisherCreateDTO {

    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Cidade não pode estar vazia!")
    private String city;
}
