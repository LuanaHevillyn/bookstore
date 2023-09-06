package com.WDA.bookstore.models;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "rents")
public class Rent implements Serializable {
    private static final long serialVersionUID = 1L;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getRent_date() {
        return rent_date;
    }

    public void setRent_date(LocalDate rent_date) {
        this.rent_date = rent_date;
    }

    public LocalDate getForecast_date() {
        return forecast_date;
    }

    public void setForecast_date(LocalDate forecast_date) {
        this.forecast_date = forecast_date;
    }

    public LocalDate getReturn_date() {
        return return_date;
    }

    public void setReturn_date(LocalDate return_date) {
        this.return_date = return_date;
    }
}
