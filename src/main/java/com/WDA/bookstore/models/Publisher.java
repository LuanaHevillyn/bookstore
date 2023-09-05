package com.WDA.bookstore.models;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Publishers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @OneToMany(mappedBy = "publishers")
    private List<Book> books;

}
