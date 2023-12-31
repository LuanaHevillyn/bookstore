package com.WDA.bookstore.dtos.book;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class BookCreateDTO {
    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Autor não pode estar vazio!")
    private String author;

    @Min(value = 1, message = "Coloque um id EXISTENTE e que não seja 0.")
    private Long publisherId;

    @ApiModelProperty(example = "2020", required = true)
    private Integer launch;

    @ApiModelProperty(example = "1", required = true)
    @Min(value = 1, message = "Não é permitido menos que 1 na quantidade de livros!")
    private Integer amount;

}
