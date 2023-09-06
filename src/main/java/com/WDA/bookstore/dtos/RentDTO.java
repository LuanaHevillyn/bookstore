package com.WDA.bookstore.dtos;


import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.User;
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


    @NotNull
    @NotEmpty
    private User user;

    @NotNull
    @NotEmpty
    private Book book;

    @NotNull
    @NotEmpty
    private LocalDate rent_date;

    @NotNull
    @NotEmpty
    private LocalDate forecast_date;

    @NotNull
    @NotEmpty
    private LocalDate return_date;


    public LocalDate getRent_date() {
        return rent_date;
    }

    public void setRent_date(LocalDate rent_date) {
        this.rent_date = rent_date;
    }

    public LocalDate getForecast_date() {
        return forecast_date;
    }

    public void setForecast_date(LocalDate forecast_date) {
        this.forecast_date = forecast_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }
}
