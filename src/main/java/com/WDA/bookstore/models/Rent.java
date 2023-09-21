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

    @Column(nullable = false)
    private LocalDate rent_date;

    @Column(nullable = false)
    private LocalDate forecast_date;

    @Column
    private LocalDate return_date;

    @Column(nullable = false)
    private String status;

}
