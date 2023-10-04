package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.rent.RentCreateDTO;
import com.WDA.bookstore.dtos.rent.RentUpdateDTO;
import com.WDA.bookstore.models.Book;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component("rentDocs")
public class RentMapper {

    private ModelMapper modelMapper;

    public RentMapper() {
        modelMapper = new ModelMapper();
    }

    public Rent mapTo(@Valid RentCreateDTO rentCreateDTO) {
        Rent rent = new Rent();
        User user = new User();
        Book book = new Book();
        user.setId(rentCreateDTO.getUserId());
        rent.setUser(user);
        book.setId(rentCreateDTO.getBookId());
        rent.setBook(book);
        rent.setForecastDate(rentCreateDTO.getForecastDate());
        return rent;
    }

    public Rent mapTo(@Valid RentUpdateDTO rentUpdateDTO) {
        Rent rent = new Rent();
        User user = new User();
        Book book = new Book();
        user.setId(rentUpdateDTO.getUserId());
        rent.setUser(user);
        book.setId(rentUpdateDTO.getBookId());
        rent.setBook(book);
        rent.setId(rentUpdateDTO.getId());
        rent.setReturnDate(rentUpdateDTO.getReturnDate());
        return rent;
    }

}
