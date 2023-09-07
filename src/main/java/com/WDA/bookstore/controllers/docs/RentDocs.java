package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.RentDTO;
import com.WDA.bookstore.models.Rent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("rentDocs")
public class RentDocs {

    private ModelMapper modelMapper;

    public RentDocs() {
        modelMapper = new ModelMapper();
    }

    public Rent mapTo(RentDTO rentDTO) {
        return modelMapper.map(rentDTO, Rent.class);
    }
}
