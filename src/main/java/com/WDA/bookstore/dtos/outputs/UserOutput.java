package com.WDA.bookstore.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserOutput {

    private Long id;

    private String name;

    private String city;

    private String email;

    private String address;

    private int total_rents;
}
