package com.WDA.bookstore.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Rents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Book book;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate rent_date;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate forecast_date;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate return_date;

}
