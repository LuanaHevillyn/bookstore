package com.WDA.bookstore.dtos.rent;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
@Getter
@Setter
public class RentCreateDTO {
    @ManyToOne(cascade = {CascadeType.MERGE})
    private Long userId;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Long bookId;

    @Column(nullable = false, name = "forecast_date")
    private LocalDate forecastDate;

}
