package com.WDA.bookstore.dtos.rent;

import com.WDA.bookstore.dtos.book.BookGetDTO;
import com.WDA.bookstore.dtos.user.UserGetDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class RentGetDTO {

    private Long id;

    private UserGetDTO user;

    private BookGetDTO book;

    private LocalDate rentDate;

    private LocalDate forecastDate;

    private LocalDate returnDate;

    private String status;
}
