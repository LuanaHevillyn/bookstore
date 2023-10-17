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

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int launch;

    @Column(nullable = false)
    private int amount;

    @Column(name = "total_leased")
    private int totalLeased;

    @OneToMany(mappedBy = "book")
    private List<Rent> rents;

}
