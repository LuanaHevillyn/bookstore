package com.WDA.bookstore.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookOutput {

    private Long id;

    private String name;

    private String author;

    private PublisherOutput publisher;

    private Integer launch;

    private Integer amount;

    private int totalLeased;
}
