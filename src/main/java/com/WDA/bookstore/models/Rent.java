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

<<<<<<< HEAD
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id")
=======
    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;

    @ManyToOne(cascade = {CascadeType.MERGE})
>>>>>>> ee54ec78baaa1faf65652bfae8fb0938275649e4
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
