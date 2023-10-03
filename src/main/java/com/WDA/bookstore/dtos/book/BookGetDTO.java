package com.WDA.bookstore.dtos.book;

import com.WDA.bookstore.dtos.publisher.PublisherGetDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BookGetDTO {
    private Long id;

    private String name;

    private PublisherGetDTO publisher;

    private String author;

    private int launch;

    private int amount;

    private int totalLeased;
}
