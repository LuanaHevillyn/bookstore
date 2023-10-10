package com.WDA.bookstore.mappers;

import com.WDA.bookstore.dtos.user.UserCreateDTO;
import com.WDA.bookstore.dtos.user.UserUpdateDTO;
import com.WDA.bookstore.models.User;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@Component
public class UserMapper {

    public User mapTo(@Valid UserCreateDTO userCreateDTO) {
        User user = new User();
        user.setId(0L);
        user.setName(userCreateDTO.getName());
        user.setEmail(userCreateDTO.getEmail());
        user.setCity(userCreateDTO.getCity());
        user.setAddress(userCreateDTO.getAddress());
        return user;
    }

    public User mapTo(@Valid UserUpdateDTO userUpdateDTO) {
        User user = new User();
        user.setId(userUpdateDTO.getId());
        user.setName(userUpdateDTO.getName());
        user.setEmail(userUpdateDTO.getEmail());
        user.setCity(userUpdateDTO.getCity());
        user.setAddress(userUpdateDTO.getAddress());
        return user;
    }
}
