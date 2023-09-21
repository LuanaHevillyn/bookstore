package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.inputs.RentInput;
import com.WDA.bookstore.models.Rent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("rentDocs")
public class RentMapper {

    private ModelMapper modelMapper;

    public RentMapper() {
        modelMapper = new ModelMapper();
    }

    public Rent mapTo(RentInput rentInput) {
        return modelMapper.map(rentInput, Rent.class);
    }
}
