package com.WDA.bookstore.dtos;


import com.WDA.bookstore.models.Publisher;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {


    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String author;

    @NotNull
    @NotEmpty
    private Publisher publisher;

    @NotNull
    @NotEmpty
    private LocalDate launch;

    @NotNull
    @NotEmpty
    private Integer amount;

    @NotNull
    @NotEmpty
    private Integer total_leased;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDate getLaunch() {
        return launch;
    }

    public void setLaunch(LocalDate launch) {
        this.launch = launch;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getTotal_leased() {
        return total_leased;
    }

    public void setTotal_leased(Integer total_leased) {
        this.total_leased = total_leased;
    }
}
