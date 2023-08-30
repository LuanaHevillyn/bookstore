package com.WDA.bookstore.users.entity;

import com.WDA.bookstore.rents.entity.Rents;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String address;

    @OneToMany(mappedBy = "users")
    private List<Rents> rents;


}
