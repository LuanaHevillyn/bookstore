package com.WDA.bookstore.dtos.inputs;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {

    private Long id;

    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @NotEmpty(message = "Autor não pode estar vazio!")
    private String author;

    private PublisherInput publisher;

    @ApiModelProperty(example = "2020", required = true)
    private Integer launch;

    @ApiModelProperty(example = "1", required = true)
    @Min(value = 1, message = "Não é permitido menos que 1 na quantidade de livros!")
    private Integer amount;

    private Integer totalLeased;
}
