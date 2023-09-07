package com.WDA.bookstore.dtos;


import com.WDA.bookstore.models.Publisher;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {


    @ApiModelProperty(example = "Nome", required = true)
    @JsonProperty("Nome")
    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @ApiModelProperty(example = "Autor", required = true)
    @JsonProperty("Autor")
    @NotEmpty(message = "Autor não pode estar vazio!")
    private String author;

    @ApiModelProperty(example = "Editora", required = true)
    @JsonProperty("Editora")
    private Publisher publisher;

    @ApiModelProperty(example = "YYYY", required = true)
    @JsonProperty("Lançamento")
    @Min ( value = 4, message = "Coloque apenas o ano!")
    private Integer launch;

    @ApiModelProperty(example = "Quantidade", required = true)
    @JsonProperty("Quantidade")
    @Min ( value = 1, message = "Não é permitido menos que 1 na quantidade de livros!")
    private Integer amount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getLaunch() {
        return launch;
    }

    public void setLaunch(Integer launch) {
        this.launch = launch;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }
}
