package com.WDA.bookstore.dtos;


import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentDTO {
    
    @ApiModelProperty(example = "Usuário", required = true)
    @JsonProperty("Usuário")
    private User user;

    @ApiModelProperty(example = "Livro", required = true)
    @JsonProperty("Livro")
    private Book book;

    @ApiModelProperty(example = "Data de aluguel", required = true)
    @JsonProperty("Data de aluguel")
    @NotEmpty(message = "A data de aluguel não pode estar vazia!")
    private String rent_date;

    @ApiModelProperty(example = "Data de previsão", required = true)
    @JsonProperty("Data de previsão")
    private String forecast_date;

    @ApiModelProperty(example = "Data de devolução")
    @JsonProperty("Data de devolução")
    private String return_date;


    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getForecast_date() {
        return forecast_date;
    }

    public void setForecast_date(String forecast_date) {
        this.forecast_date = forecast_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }
}
