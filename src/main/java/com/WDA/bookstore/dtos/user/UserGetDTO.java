package com.WDA.bookstore.dtos.user;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UserGetDTO {

    private Long id;

    private String name;

    private String city;

    private String email;

    private String address;

    private int totalRents;
}
