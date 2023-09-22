package com.WDA.bookstore.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "rents")
public class Rent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Book book;

    @Column(nullable = false, name = "rent_date")
    private LocalDate rentDate;

    @Column(nullable = false, name = "forecast_date")
    private LocalDate forecastDate;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(nullable = false)
    private String status;

}
