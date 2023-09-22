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

    private LocalDate rentDate;

    private LocalDate forecastDate;

    private LocalDate returnDate;

    private String status;
}
