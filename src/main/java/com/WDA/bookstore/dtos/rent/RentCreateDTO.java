package com.WDA.bookstore.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDate;
@Getter
@Setter
public class RentCreateDTO {

    private Long userId;

    private Long bookId;

    private LocalDate forecastDate;
}
