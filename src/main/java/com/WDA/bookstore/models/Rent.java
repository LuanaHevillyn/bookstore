package com.WDA.bookstore.models;

import javax.persistence.*;
import java.io.Serializable;

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

    @Column(nullable = false)
    private String rent_date;

    @Column(nullable = false)
    private String forecast_date;

    private String return_date;

    @Column(nullable = false)
    private String status;

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

    public String getRent_date() {
        return rent_date;
    }

    public void setRent_date(String rent_date) {
        this.rent_date = rent_date;
    }

    public String getForecast_date() {
        return forecast_date;
    }

    public void setForecast_date(String forecast_date) {
        this.forecast_date = forecast_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {
        this.return_date = return_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
