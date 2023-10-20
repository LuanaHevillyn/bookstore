package com.WDA.bookstore.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.FutureOrPresent;
import java.time.LocalDate;
@Getter
@Setter
public class RentUpdateDTO {

    private Long id;

    private Long userId;

    private Long bookId;

    @FutureOrPresent
    private LocalDate returnDate;
}
