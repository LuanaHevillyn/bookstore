package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.publisher.PublisherCreateDTO;
import com.WDA.bookstore.dtos.publisher.PublisherUpdateDTO;
import com.WDA.bookstore.dtos.user.UserCreateDTO;
import com.WDA.bookstore.dtos.user.UserUpdateDTO;
import com.WDA.bookstore.models.Publisher;
import com.WDA.bookstore.models.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component("userDocs")
public class UserMapper {
    private ModelMapper modelMapper;

    public UserMapper() {
        modelMapper = new ModelMapper();
    }

    public User mapTo(@Valid UserCreateDTO userCreateDTO) {
        return modelMapper.map(userCreateDTO, User.class);
    }

    public User mapTo(@Valid UserUpdateDTO userUpdateDTO) {
        return modelMapper.map(userUpdateDTO, User.class);
    }
}
