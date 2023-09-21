package com.WDA.bookstore.dtos.outputs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PublisherOutput {

    private Long id;

    private String name;

    private String city;

    private int related_books;
}
