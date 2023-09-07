package com.WDA.bookstore.dtos;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PublisherDTO {

    @ApiModelProperty(example = "Nome", required = true)
    @JsonProperty("Nome")
    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @ApiModelProperty(example = "Cidade", required = true)
    @JsonProperty("Cidade")
    @NotEmpty(message = "Cidade não pode estar vazia!")
    private String city;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
