package com.WDA.bookstore.publishers.entity;

import com.WDA.bookstore.books.entity.Books;
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
    private List<Books> books;

}
