package com.WDA.bookstore.books.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BooksDTO {


    private Long id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private LocalDate launch;

    @NotNull
    @NotEmpty
    private Integer amount;

    @NotNull
    @NotEmpty
    private Integer total_leased;

}
