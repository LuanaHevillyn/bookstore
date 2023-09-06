package com.WDA.bookstore.controllers.docs;

import com.WDA.bookstore.dtos.RentDTO;
import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.models.Rent;
import com.WDA.bookstore.models.User;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.stereotype.Component;

@Component("rentDocs")
public class RentDocs {

    private ModelMapper modelMapper;

    final Converter<RentDTO, Rent> rentConverter = new Converter<RentDTO, Rent>() {

        @Override
        public Rent convert(MappingContext<RentDTO, Rent> context) {
            RentDTO rentDTO = context.getSource();
            Rent rent = new Rent();
            rent.setUser (rentDTO.getUser ());
            rent.setBook (rentDTO.getBook ());
            rent.setRent_date (rentDTO.getRent_date ());
            rent.setForecast_date (rentDTO.getForecast_date ());
            rent.setReturn_date (rentDTO.getReturn_date ());

            return rent;
        }
    };

    public RentDocs() {
        modelMapper = new ModelMapper();
        modelMapper.addConverter(rentConverter);
    }

    public Rent mapTo(RentDTO rentDTO) {
        return this.modelMapper.map(rentDTO, Rent.class);
    }
}
