package com.WDA.bookstore.rents.entity;

import com.WDA.bookstore.books.entity.Books;
import com.WDA.bookstore.users.entity.Users;
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
    private Users users;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Books books;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate rent_date;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate forecast_date;

    @Column(nullable = false, columnDefinition = "DATE")
    private LocalDate return_date;

}
