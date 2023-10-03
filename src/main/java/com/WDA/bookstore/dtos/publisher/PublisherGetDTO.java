package com.WDA.bookstore.dtos.publisher;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class PublisherGetDTO {
    private Long id;

    private String name;

    private String city;

    private int relatedBooks;
}
