package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.inputs.UserInput;
import com.WDA.bookstore.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component("userDocs")
public class UserMapper {
    private ModelMapper modelMapper;

    public UserMapper() {
        modelMapper = new ModelMapper();
    }

    public User mapTo(UserInput userInput) {
        return modelMapper.map(userInput, User.class);
    }
}
