package com.WDA.bookstore.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Getter
@Setter
public class RentUpdateDTO {

    private Long id;

    private Long userId;

    private Long bookId;

    private LocalDate returnDate;
}
