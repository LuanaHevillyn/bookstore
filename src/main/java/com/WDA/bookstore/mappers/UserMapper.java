package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.UserDTO;
import com.WDA.bookstore.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("userDocs")
public class UserMapper {
    private ModelMapper modelMapper;

    public UserMapper() {
        modelMapper = new ModelMapper();
    }

    public User mapTo(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }
}
