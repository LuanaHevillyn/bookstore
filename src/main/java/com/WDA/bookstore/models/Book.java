package com.WDA.bookstore.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int launch;

    @Column(nullable = false)
    private int amount;

    @Column
    private int total_leased;

    @OneToMany(mappedBy = "book")
    private List<Rent> rents;

}
