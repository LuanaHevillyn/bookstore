package com.WDA.bookstore.dtos.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserCreateDTO {

    private String name;

    private String city;

    private String email;

    private String address;
}
