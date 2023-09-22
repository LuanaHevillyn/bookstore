package com.WDA.bookstore.dtos.inputs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherInput {

    private Long id;

    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Cidade não pode estar vazia!")
    private String city;

    private Integer relatedBooks;

}
