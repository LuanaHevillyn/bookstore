package com.WDA.bookstore.dtos;


import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentDTO {

    private User user;

    private Book book;

    @NotEmpty(message = "A data de aluguel não pode estar vazia!")
    private String rent_date;

    @NotEmpty(message = "A data de previsão não pode estar vazia!")
    private String forecast_date;

    private String return_date;

}
