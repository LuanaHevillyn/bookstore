package com.WDA.bookstore.books.entity;

import com.WDA.bookstore.publishers.entity.Publishers;
import com.WDA.bookstore.rents.entity.Rents;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publishers publishers;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, length = 4, columnDefinition = "DATE")
    private LocalDate launch;

    @Column(nullable = false)
    private int amount;

    @Column(nullable = false)
    private int total_leased;

    @OneToMany(mappedBy = "books")
    private List<Rents> rents;

}
