package com.WDA.bookstore.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Getter
@Setter
public class RentCreateDTO {

    @Min(value = 1, message = "Coloque um id EXISTENTE e que não seja 0.")
    private Long userId;

    @Min(value = 1, message = "Coloque um id EXISTENTE e que não seja 0.")
    private Long bookId;

    @FutureOrPresent
    private LocalDate forecastDate;
}
