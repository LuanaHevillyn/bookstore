package com.WDA.bookstore.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class RentOutput {

    private Long id;

    private UserOutput user;

    private BookOutput book;

    private LocalDate rent_date;

    private LocalDate forecast_date;

    private LocalDate return_date;

    private String status;
}
