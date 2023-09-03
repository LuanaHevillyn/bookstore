package com.WDA.bookstore.rents.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentsDTO {

    private Long id;

    @NotNull
    @NotEmpty
    private LocalDate rent_date;


    @NotNull
    @NotEmpty
    private LocalDate forecast_date;

    @NotNull
    @NotEmpty
    private LocalDate return_date;



    @NotNull
    @NotEmpty
    private LocalDate forecast_date;

    @NotNull
    @NotEmpty
    private LocalDate return_date;
    
}
