package com.WDA.bookstore.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;


@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    @ApiModelProperty(example = "Nome", required = true)
    @JsonProperty("Nome")
    @NotEmpty(message = "Nome não pode estar vazio!")
    private String name;

    @ApiModelProperty(example = "Cidade", required = true)
    @JsonProperty("Cidade")
    @NotEmpty(message = "Cidade não pode estar vazio!")
    private String city;

    @ApiModelProperty(example = "E-mail@email.com", required = true)
    @JsonProperty("E-mail")
    @NotEmpty(message = "E-mail não pode estar vazio!")
    @Email
    private String email;

    @ApiModelProperty(example = "Endereço", required = true)
    @JsonProperty("Endereço")
    @NotEmpty(message = "Endereço não pode estar vazio!")
    private String address;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


}
